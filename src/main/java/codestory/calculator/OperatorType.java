package codestory.calculator;

/**
 * Enumeration of all operator types in a math expression.
 * Priority is the priority of an operator compared to another operator when constructing the math expression tree.
 */
public enum OperatorType {

	ADD ('+', 1),
	SUBSTRACT ('-', 1),
	MULTIPLY ('*', 2),
	DIVIDE ('/', 2),
	PARENTHESIS ('(', 0);

	
	private char character;
	private int priority;
	
	
	private OperatorType(char character, int priority) {
		this.character = character;
		this.priority = priority;
	}

	public char getCharacter() {
		return character;
	}

	public int getPriority() {
		return priority;
	}
	
	public static OperatorType valueOf(char character) {
		for (OperatorType operatorType : values()) {
			if (operatorType.getCharacter() == character) {
				return operatorType;
			}
		}
		
		throw new IllegalArgumentException("the character " + character + " is unknown");
	}
}
