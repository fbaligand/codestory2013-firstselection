package codestory.resource;

import static org.junit.Assert.assertEquals;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

import org.junit.Test;

public class EnonceResourceTest {
	
	private EnonceResource enonceResource = new EnonceResource();

	@Test
	public void testProcessEnonce() {
		Response response = enonceResource.processEnonce("1", "enonce 1");
		assertEquals(HttpServletResponse.SC_CREATED, response.getStatus());
		assertEquals("Contenu de l'énoncé 1 bien reçu, je vais y réfléchir...", response.getEntity());
	}
	
}
