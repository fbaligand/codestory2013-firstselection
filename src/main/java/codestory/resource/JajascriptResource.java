package codestory.resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.jboss.resteasy.spi.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import codestory.bean.BestPlanning;
import codestory.bean.Flight;

/**
 * Ressource REST 'jajascript', qui reçoit des requêtes d'optimisation de planning de vols, 
 * et qui renvoie le meilleur planning trouvé au format JSON
 */
@Path("/jajascript")
public class JajascriptResource {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JajascriptResource.class);

	/**
	 * Calcule et retourne le meilleur planning possible (en terme de gain) pour la liste des vols reçus
	 * @param request liste des vols à planifier au format JSON
	 * @return le meilleur planning trouvé au format JSON
	 */
	@POST
	@Path("/optimize")
	@Produces("application/json; charset=UTF-8")
	public BestPlanning processOptimize(String request) {
		try {
			List<Flight> flights = new ObjectMapper().readValue(request, new TypeReference<List<Flight>>(){});

			LOGGER.info("flightsCount: " + flights.size());
			if (flights.size() < 1000) {
				LOGGER.info("flights: " + request);
			}
			
			Comparator<Integer> reverseComparator = new Comparator<Integer>() {
				public int compare(Integer o1, Integer o2) {
					return o1.compareTo(o2) * (-1);
				}
			};
			
			// Construction de la map des vols par heure de départ
			NavigableMap<Integer, List<Flight>> flightsMap = new TreeMap<Integer, List<Flight>>(reverseComparator);
			for (Flight flight : flights) {
				List<Flight> mapValue = flightsMap.get(flight.getDepart());
				if (mapValue == null) {
					mapValue = new ArrayList<Flight>();
//					mapValue = new LinkedList<Flight>();
					flightsMap.put(flight.getDepart(), mapValue);
				}
				mapValue.add(flight);
			}
			
			// Stockage du meilleur planning par heure de départ
			Map<Integer, BestPlanning> bestPlanningMap = new HashMap<Integer, BestPlanning>(flightsMap.size());

			// Calcul du meilleur planning (en le calculant pour chaque heure de départ, de la dernière à la première)
			BestPlanning bestPlanning = new BestPlanning();
			int maxDepartureTime = flightsMap.firstKey();
			
			for (Map.Entry<Integer, List<Flight>> flightsEntry : flightsMap.entrySet()) {
				bestPlanning = computeBestPlanning(flightsEntry.getValue(), bestPlanning, bestPlanningMap, maxDepartureTime);
				bestPlanningMap.put(flightsEntry.getKey(), bestPlanning);
			}
			
			LOGGER.info("bestPlanningPathCount: " + bestPlanning.getPathSize());
			if (bestPlanning.getPathSize() < 1000) {
				LOGGER.info("bestPlanning: " + bestPlanning);
			}

			return bestPlanning;
		}
		catch (JsonProcessingException e) {
			throw new BadRequestException("Erreur lors du parsing JSON des vols en request", e);
		}
		catch (IOException e) {
			throw new BadRequestException("Erreur lors du parsing JSON des vols en request", e);
		}
		catch (StackOverflowError e) {
			throw new StackOverflowError("Erreur de récursion trop profonde, dûe à un très grand nombre de vols");
		}
	}
	
	/**
	 * Calcul du meilleur planning en terme de gain, à partir d'une heure donnée
	 * @param flightsForOneDepartureTime liste des vols pour une heure de départ donnée (lecture seule)
	 * @param previousBestPlanning meilleur planning calculé lors de la précédente itération (lecture seule) 
	 * @param bestPlanningMap map des meilleurs plannings trouvés par heure de départ (lecture/écriture) 
	 * @param maxDepartureTime heure de départ maximum de tous les vols
	 * @return le meilleur planning possible en partant de l'heure de départ en paramètre
	 */
	public BestPlanning computeBestPlanning(List<Flight> flightsForOneDepartureTime, BestPlanning previousBestPlanning, Map<Integer, BestPlanning> bestPlanningMap, int maxDepartureTime) {
		
		// Meilleur planning pour l'heure de départ demandée
		BestPlanning bestPlanning = previousBestPlanning;
		
		for (Flight flight : flightsForOneDepartureTime) {
			
			// Récupération du meilleur planning avec les vols suivants le vol en cours
			BestPlanning followingFlightsBestPlanning = null;
			for (int i=flight.getDepart() + flight.getDuree() ; i<=maxDepartureTime ; ++i) {
				followingFlightsBestPlanning = bestPlanningMap.get(i);
				if (followingFlightsBestPlanning != null) {
					break;
				}
			}
			if (followingFlightsBestPlanning == null) {
				followingFlightsBestPlanning = new BestPlanning();
			}
			
			// Mise à jour du meilleur planning (si on a trouvé mieux avec ce vol)
			if (flight.getPrix() + followingFlightsBestPlanning.getGain() > bestPlanning.getGain()) {
				bestPlanning = new BestPlanning(flight, followingFlightsBestPlanning);
			}
		}

		// Retour du meilleur planning trouvé
		return bestPlanning;
	}
	
}
