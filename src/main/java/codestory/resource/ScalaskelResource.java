package codestory.resource;

import static codestory.bean.Piece.NAVIGABLE_PIECES;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import codestory.bean.Decomposition;
import codestory.bean.Piece;

/**
 * Ressource REST 'scalaskel' qui trouve toutes les décompositions possibles en pièces,
 * d'un montant en cents reçu en entrée 
 */
@Path("/scalaskel")
public class ScalaskelResource {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ScalaskelResource.class);
	
	/**
	 * Calcule et retourne toutes les décompositions possibles en pièces du montant <code>cents</code> donné en paramètre
	 * @param cents montant en cents à décomposer en pièces
	 * @return toutes les décompositions possibles en pièces du montant <code>cents</code> donné en paramètre
	 */
	@GET
	@Path("/change/{cents}")
	@Produces("application/json; charset=UTF-8")
	public List<Decomposition> processChange(@PathParam("cents") int cents) {
		
		List<Decomposition> decompositions = new ArrayList<Decomposition>();
		computeDecompositions(cents, decompositions, new Decomposition(), NAVIGABLE_PIECES.last());
		
		LOGGER.info("decompositions: " + decompositions);
		
		return decompositions;
	}
	
	/**
	 * Calcule récursif des décompositions du prix <code>totalPrice</code> en pièces
	 * @param totalPrice prix total à atteindre en cents
	 * @param decompositions liste des décompositions de <code>totalPrice</code> à mettre à jour
	 * @param parentDecomposition décomposition de l'itération récursive parente
	 * @param currentPiece pièce de l'itération courante dont il faut déterminer le nombre
	 */
	void computeDecompositions(int totalPrice, List<Decomposition> decompositions, Decomposition parentDecomposition, Piece currentPiece) {

		// Calcul du prix à atteindre pour cette itération
		int priceToReach = totalPrice - parentDecomposition.computePrice();

		// Clonage de la décomposition parent
		Decomposition currentDecomposition = parentDecomposition.clone();
		
		// Calcul du nombre de pièces nécessaire
		int pieceCount = priceToReach / currentPiece.getCentsValue();
		
		// Si on est arrivé à la plus petite pièce, alors ajout dans la liste des décompositions trouvées
		if (currentPiece == NAVIGABLE_PIECES.first()) {
			currentDecomposition.setPieceCount(currentPiece, pieceCount);
			decompositions.add(currentDecomposition);
		}
		// Sinon calcul récursif des décompositions
		else {
			do {
				// Appel récursif avec la pièce de montant inférieur
				currentDecomposition.setPieceCount(currentPiece, pieceCount);
				computeDecompositions(totalPrice, decompositions, currentDecomposition, NAVIGABLE_PIECES.lower(currentPiece));
				
				// On diminue d'un cran le nombre de pièces, et on calcule les décompositions qui en découlent
				--pieceCount;
			} while (pieceCount >= 0);
		}
	}
}
