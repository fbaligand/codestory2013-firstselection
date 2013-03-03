package codestory.bean;

import org.codehaus.jackson.annotate.JsonValue;

/**
 * Bean contenant un maillon de la chaine des vols d'un bean <code>BestPlanning</code>.
 * Il définit le nom du vol du maillon, et le prochain maillon de la chaine des vols du meilleur planning associé
 */
public class BestPlanningPathElement {

	////////////
	// Fields //
	////////////

	private final String flightName;
	private final BestPlanningPathElement nextElement;

	
	//////////////////
	// Constructors //
	//////////////////

	public BestPlanningPathElement(String flightName, BestPlanningPathElement nextElement) {
		this.flightName = flightName;
		this.nextElement = nextElement;
	}
	
	
	////////////////////////
	// Geters and Setters //
	////////////////////////

	public String getFlightName() {
		return flightName;
	}

	public BestPlanningPathElement getNextElement() {
		return nextElement;
	}

	
	//////////////
	// ToString //
	//////////////

	@JsonValue
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder("[");
		BestPlanningPathElement iterator = this;
		
		do {
			stringBuilder.append("\"").append(iterator.flightName).append("\"");
			if (iterator.nextElement != null) {
				stringBuilder.append(",");
			}
			iterator = iterator.nextElement;
		}
		while (iterator != null);
		
		stringBuilder.append("]");
		
		return stringBuilder.toString();
	}
}
