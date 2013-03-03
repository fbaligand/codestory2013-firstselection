package codestory.bean;

import java.util.EnumSet;
import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * Enumeration listant l'ensemble des pièces de la monnaie de la planète Scalaskel,
 * avec pour chacune, sa valeur en cents
 */
public enum Piece {
	
	FOO(1),
	BAR(7),
	QIX(11),
	BAZ(21);

	public static final NavigableSet<Piece> NAVIGABLE_PIECES = new TreeSet<Piece>(EnumSet.allOf(Piece.class));
	
	private int centsValue;
	
	private Piece(int centsValue) {
		this.centsValue = centsValue;
	}

	public int getCentsValue() {
		return centsValue;
	}

	@Override
	public String toString() {
		return name().toLowerCase();
	}
}
