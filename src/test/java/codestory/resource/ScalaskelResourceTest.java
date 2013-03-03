package codestory.resource;

import static junit.framework.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import codestory.bean.Decomposition;

public class ScalaskelResourceTest {
	
	private ScalaskelResource scalaskelResource = new ScalaskelResource();

	@Test
	public void testProcessChange1() {
		List<Decomposition> decompositions = scalaskelResource.processChange(1);
		assertEquals(1, decompositions.size());
		assertEquals(1, decompositions.get(0).getFoo());
	}

	@Test
	public void testProcessChange8() {
		List<Decomposition> decompositions = scalaskelResource.processChange(8);
		assertEquals(2, decompositions.size());
		assertEquals(1, decompositions.get(0).getBar());
		assertEquals(1, decompositions.get(0).getFoo());
		assertEquals(0, decompositions.get(1).getBar());
		assertEquals(8, decompositions.get(1).getFoo());
	}
}
