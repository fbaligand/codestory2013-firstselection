package codestory.bean;

import static codestory.bean.Piece.*;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

/**
 * Bean représentant la décomposition en pièces de monnaie, d'un montant en cents sur la planète Skalaskel
 */
@JsonSerialize(include = Inclusion.NON_DEFAULT)
public class Decomposition implements Cloneable {
	
	////////////
	// Fields //
	////////////

	private int baz;
	private int qix;
	private int bar;
	private int foo;

	
	/////////////
	// Methods //
	/////////////

	/**
	 * calcule et retourne le prix de la décomposition 
	 * @return prix en cents
	 */
	public int computePrice() {
		return baz * BAZ.getCentsValue() + qix * QIX.getCentsValue() + bar * BAR.getCentsValue() + foo * FOO.getCentsValue();
	}

	/**
	 * Positionne le nombre de pièces d'une pièce donnée
	 * @param piece pièce concernée
	 * @param pieceCount nombre de pièces
	 */
	public void setPieceCount(Piece piece, int pieceCount) {
		switch (piece) {
		case BAZ:
			setBaz(pieceCount);
			break;
		case QIX:
			setQix(pieceCount);
			break;
		case BAR:
			setBar(pieceCount);
			break;
		case FOO:
			setFoo(pieceCount);
			break;
		}
	}
	
	/**
	 * Clone la décomposition courante et retourne le clone
	 */
	public Decomposition clone() {
		try {
			return (Decomposition) super.clone();
		} catch (CloneNotSupportedException e) {
			// Ne doit jamais arriver
			throw new UnsupportedOperationException(e);
		}
	}

		
	////////////////////////
	// Geters and Setters //
	////////////////////////

	public int getBaz() {
		return baz;
	}
	public void setBaz(int baz) {
		this.baz = baz;
	}
	public int getQix() {
		return qix;
	}
	public void setQix(int qix) {
		this.qix = qix;
	}
	public int getBar() {
		return bar;
	}
	public void setBar(int bar) {
		this.bar = bar;
	}
	public int getFoo() {
		return foo;
	}
	public void setFoo(int foo) {
		this.foo = foo;
	}
	

	//////////////
	// ToString //
	//////////////

	@Override
	public String toString() {
		return "Change [baz=" + baz + ", qix=" + qix + ", bar=" + bar + ", foo=" + foo + "]";
	}
}
