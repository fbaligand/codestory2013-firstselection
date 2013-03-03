package codestory.resource;

import java.text.MessageFormat;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Ressource REST 'enonce', qui reçoit des énoncés, les logge et retourne un code HTTP 401 (CREATED),
 * acquiescant la bonne réception de la requête
 */
@Path("/enonce")
public class EnonceResource {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EnonceResource.class);
	
	private static final String RESPONSE_CONTENT = "Contenu de l''énoncé {0} bien reçu, je vais y réfléchir...";

	/**
	 * Reçoit et logge le contenu d'un énoncé
	 * @param enonceId identifiant de l'énoncé
	 * @param enonceContent contenu de l'énoncé
	 * @return code HTTP 401 (CREATED) acquiescant la bonne réception de l'énoncé
	 */
	@POST
	@Path("/{enonceId}")
	@Produces("text/plain; charset=UTF-8")
	public Response processEnonce(@PathParam("enonceId") String enonceId, String enonceContent) {
		
		LOGGER.info("enonceId: " + enonceId);
		LOGGER.info("enonceContent: " + enonceContent);

		return Response.status(Status.CREATED)
				       .entity(MessageFormat.format(RESPONSE_CONTENT, enonceId))
				       .build();
	}
	
}
