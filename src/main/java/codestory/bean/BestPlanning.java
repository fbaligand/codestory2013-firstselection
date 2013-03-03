package codestory.bean;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonRawValue;

/**
 * Bean contenant les infos du meilleur planning (en terme de gain) du Jajascript :
 * - gain: montant du gain
 * - path: liste des vols planifiés, par ordre d'horaire de départ
 * - pathSize: nombre de vols planifiés
 * 
 * Le bean est sérialisable en JSON grâce aux annotations Jackson
 */
public class BestPlanning {

	////////////
	// Fields //
	////////////

	private final int gain;
	
	@JsonRawValue
	private final BestPlanningPathElement path;
	
	@JsonIgnore
	private final int pathSize;

	
	//////////////////
	// Constructors //
	//////////////////

	public BestPlanning() {
		this.gain = 0;
		this.path = null;
		this.pathSize = 0;
	}

	public BestPlanning(Flight firstElement, BestPlanning followingElements) {
		this.gain = firstElement.getPrix() + followingElements.getGain();
		this.path = new BestPlanningPathElement(firstElement.getVol(), followingElements.getPath());
		this.pathSize = 1 + followingElements.getPathSize();
	}
	
	
	////////////////////////
	// Geters and Setters //
	////////////////////////

	public int getGain() {
		return gain;
	}
	public BestPlanningPathElement getPath() {
		return path;
	}
	public int getPathSize() {
		return pathSize;
	}

	
	//////////////
	// ToString //
	//////////////

	@Override
	public String toString() {
		return "{gain:" + gain + ", path:" + path + "}";
	}
}
