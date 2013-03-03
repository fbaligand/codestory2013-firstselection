package codestory.calculator;

import java.math.BigDecimal;

/**
 * Operand of a tree representing a math expression
 */
public class Operand extends Node {

	private BigDecimal value;

	public Operand (BigDecimal value) {
		this.value = value;
	}
	
	@Override
	public BigDecimal compute() {
		return value;
	}

	@Override
	public String toString() {
		return value.toPlainString();
	}
}
