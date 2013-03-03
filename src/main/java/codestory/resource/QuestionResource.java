package codestory.resource;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Properties;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import codestory.calculator.Calculator;

/**
 * Ressource REST 'question', qui reçoit des questions, 
 * et qui tente d'y répondre :
 * - soit par une réponse directe (OUI, NON, ...)
 * - soit par l'évaluation de l'expression mathématique demandée
 */
@Path("/")
public class QuestionResource {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(QuestionResource.class);
	
	static final String QUESTIONS_ANSWERS_FILE = "/questions-answers.properties";
	static final String MATH_EXPRESSION_REGEX = "[\\d \\-\\+\\*/\\(\\)\\,]+";
	static final String NO_QUESTION_ANSWER = "Vous devez poser une question via le paramètre 'q'";
	static final String UNKNOWN_QUESTION = "Je ne comprends pas votre question";
	
	private static Properties questionsAnswersProperties;
	
	static {
		initQuestionsAnswersProperties();
	}

	/**
	 * Reçoit une question et y répond
	 * @param question question posée
	 * @return réponse à la question
	 */
	@GET
	@Produces("text/plain; charset=UTF-8")
	public String processQuestion(@QueryParam("q") String question) {

		if (question == null || question.trim().equals("")) {
			return NO_QUESTION_ANSWER;
		}
		else if (questionsAnswersProperties.containsKey(question)) {
			return questionsAnswersProperties.getProperty(question);
		}
		else if (question.matches(MATH_EXPRESSION_REGEX)) {
			String mathExpression = question.replace(' ', '+').replace(',', '.');
			Number result = new Calculator().computeMathExpression(mathExpression);

			DecimalFormat decimalFormat = new DecimalFormat();
			DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
			decimalFormatSymbols.setDecimalSeparator(',');
			decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
			decimalFormat.setMaximumFractionDigits(Integer.MAX_VALUE);
			decimalFormat.setGroupingUsed(false);
			
			String stringResult = decimalFormat.format(result);
			return stringResult;
		}
		else {
			return UNKNOWN_QUESTION;
		}
	}
	
	/**
	 * Initialise la variable de classe {@link #questionsAnswersProperties} à partir du fichier de properties questions-answers.properties
	 */
	static void initQuestionsAnswersProperties() {
		questionsAnswersProperties = new Properties();
		InputStream questionsAnswersStream = QuestionResource.class.getResourceAsStream(QUESTIONS_ANSWERS_FILE);
		if (questionsAnswersStream != null) {
			try {
				questionsAnswersProperties.load(questionsAnswersStream);
			}
			catch (IOException e) {
				LOGGER.error("Erreur I/O lors du chargement du fichier de questions-réponses", e);
			}
			finally {
				try {
					questionsAnswersStream.close();
				}
				catch (IOException e) {}
			}
		}
		else {
			LOGGER.error("Le fichier de questions-réponses est inexistant ou n'a pas pu être chargé");
		}
	}
}
