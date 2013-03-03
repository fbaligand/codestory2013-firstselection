package codestory.resource;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class QuestionResourceTest {
	
	private QuestionResource questionResource = new QuestionResource();

	@Test
	public void testNoQuestion() {
		String answer = questionResource.processQuestion(null);
		assertEquals(QuestionResource.NO_QUESTION_ANSWER, answer);
	}
	
	@Test
	public void testUnknownQuestion() {
		String answer = questionResource.processQuestion("Question inexistante");
		assertEquals(QuestionResource.UNKNOWN_QUESTION, answer);
	}
	
	@Test
	public void testEmailQuestion() {
		String answer = questionResource.processQuestion("Quelle est ton adresse email");
		assertEquals("fbaligand@gmail.com", answer);
	}
	
	@Test
	public void testSimpleMathQuestion() {
		String answer = questionResource.processQuestion("(4+2)/2");
		assertEquals("3", answer);
	}
	
	@Test
	public void testSimpleNegativeMathQuestion() {
		String answer = questionResource.processQuestion("(4+2)/(-2)");
		assertEquals("-3", answer);
	}
	
	@Test
	public void testDecimalMathQuestion() {
		String answer = questionResource.processQuestion("(1+2)/2");
		assertEquals("1,5", answer);
	}
	
	@Test
	public void testDecimalMathQuestion2() {
		String answer = questionResource.processQuestion("1,5*1,5");
		assertEquals("2,25", answer);
	}
	
	@Test
	public void testDecimalMathQuestion3() {
		String answer = questionResource.processQuestion("1,5*4");
		assertEquals("6", answer);
	}
	
	@Test
	public void testComplexMathQuestion() {
		String answer = questionResource.processQuestion("((1,1 2) 3,14 4 (5 6 7) (8 9 10)*4267387833344334647677634)/2*553344300034334349999000");
		assertEquals("31878018903828899277492024491376690701584023926880", answer);
	}
	
	@Test
	public void testComplexMathQuestion2() {
		String answer = questionResource.processQuestion("(((1,1 2) 3,14 4 (5 6 7) (8 9 10)*4267387833344334647677634)/2*553344300034334349999000)/31878018903828899277492024491376690701584023926880");
		assertEquals("1", answer);
	}
	
	@Test
	public void testComplexMathQuestion3() {
		String answer = questionResource.processQuestion("1,0000000000000000000000000000000000000000000000001*1,0000000000000000000000000000000000000000000000001");
		assertEquals("1,00000000000000000000000000000000000000000000000020000000000000000000000000000000000000000000000001", answer);
	}
}
