package codestory.calculator;

import java.math.BigDecimal;

/**
 * Node of a tree representing a math expression :
 * - either an operator
 * - either an operand
 */
public abstract class Node {

	private Operator parent;
	
	public abstract BigDecimal compute();

	public Operator getParent() {
		return parent;
	}

	public void setParent(Operator parent) {
		this.parent = parent;
	}
}
