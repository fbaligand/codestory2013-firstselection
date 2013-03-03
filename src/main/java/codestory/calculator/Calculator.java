package codestory.calculator;

import java.math.BigDecimal;
import java.util.regex.Pattern;

import static codestory.calculator.OperatorType.*;

/**
 * Component that computes math expressions
 */
public class Calculator {
	
	/**
	 * Compute a math expression and return the result as a BigDecimal
	 * @param mathExpression math expression to compute
	 * @return result of the math expression
	 */ 
	public BigDecimal computeMathExpression(String mathExpression) {
		
		Node rootNode = new Operator(PARENTHESIS);
		Node currentNode = rootNode;
		
		int currentIndex = 0;

		do {
			char currentChar = mathExpression.charAt(currentIndex);
			
			// Number
			if (Character.isDigit(currentChar)) {
				String fullNumber = String.valueOf(currentChar);
				while (currentIndex + 1 < mathExpression.length()) {
					char nextChar = mathExpression.charAt(currentIndex+1);
					if (Character.isDigit(nextChar) || nextChar == '.') {
						fullNumber += nextChar;
						++currentIndex;
					}
					else {
						break;
					}
				}
				Operand newNode = new Operand(new BigDecimal(fullNumber));
				((Operator)currentNode).addNode(newNode);
				currentNode = newNode;
			}
			
			// Negative Number
			else if (currentChar == SUBSTRACT.getCharacter() && currentNode instanceof Operator) {
				Operator newNode = new Operator(MULTIPLY);
				newNode.addNode(new Operand(new BigDecimal("-1")));
				((Operator)currentNode).addNode(newNode);
				currentNode = newNode;
			}
			
			// Open Parenthesis
			else if (currentChar == PARENTHESIS.getCharacter()) {
				Operator newNode = new Operator(PARENTHESIS);
				((Operator)currentNode).addNode(newNode);
				currentNode = newNode;
			}
			
			// Close Parenthesis
			else if (currentChar == ')') {
				Operator parenthesisAncestor = currentNode.getParent();
				while (parenthesisAncestor.getType() != PARENTHESIS) {
					parenthesisAncestor = parenthesisAncestor.getParent();
				}
				currentNode = parenthesisAncestor;
			}
			
			// Operator +-*/
			else if (Pattern.matches("[\\+\\-\\*\\/]", ""+currentChar)) {
				Operator newNode = new Operator(OperatorType.valueOf(currentChar));
				Node child = currentNode;
				Operator parent = child.getParent();
				while (parent.getType().getPriority() >= newNode.getType().getPriority()) {
					child = parent;
					parent = child.getParent();
				}
				newNode.addNode(child);
				if (parent.getLeftNode() == child) {
					parent.setLeftNode(newNode);
				}
				else {
					parent.setRightNode(newNode);
				}
				currentNode = newNode;
			}
			
			// Syntax Error
			else {
				throw new IllegalStateException("Unknow character " + currentChar + " at index " + currentIndex);
			}

			++currentIndex;
		}
		while (currentIndex < mathExpression.length());
		
		// Compute the constructed math expression tree
		return rootNode.compute();
	}

}
