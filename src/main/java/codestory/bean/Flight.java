package codestory.bean;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Bean représentant un vol proposé à la réservation du Jajascript
 */
public class Flight {

	////////////
	// Fields //
	////////////

	@JsonProperty("VOL")
	private String vol;
	
	@JsonProperty("DEPART")
	private int depart;

	@JsonProperty("DUREE")
	private int duree;

	@JsonProperty("PRIX")
	private int prix;

	
	////////////////////////
	// Geters and Setters //
	////////////////////////

	public String getVol() {
		return vol;
	}
	public void setVol(String vol) {
		this.vol = vol;
	}
	public int getDepart() {
		return depart;
	}
	public void setDepart(int depart) {
		this.depart = depart;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}

	
	//////////////
	// ToString //
	//////////////

	@Override
	public String toString() {
		return "Flight [VOL=" + vol + ", DEPART=" + depart + ", DUREE=" + duree + ", PRIX=" + prix + "]";
	}

	
	///////////////////////
	// Equals / Hashcode //
	///////////////////////

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vol == null) ? 0 : vol.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		if (vol == null) {
			if (other.vol != null)
				return false;
		} else if (!vol.equals(other.vol))
			return false;
		return true;
	}
}
