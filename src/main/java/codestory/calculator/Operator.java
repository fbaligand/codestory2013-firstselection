package codestory.calculator;

import java.math.BigDecimal;

/**
 * Operator of a tree representing a math expression.
 * An operator of type PARENTHESIS has just a left node : the content inside the parenthesis
 */
public class Operator extends Node {
	
	private OperatorType type;
	private Node leftNode;
	private Node rightNode;

	public Operator(OperatorType type) {
		this.type = type;
	}

	@Override
	public BigDecimal compute() {
		switch (type) {
		case ADD:
			return getLeftNode().compute().add(getRightNode().compute());
		case SUBSTRACT:
			return getLeftNode().compute().subtract(getRightNode().compute());
		case MULTIPLY:
			return getLeftNode().compute().multiply(getRightNode().compute());
		case DIVIDE:
			return getLeftNode().compute().divide(getRightNode().compute());
		case PARENTHESIS:
			return getLeftNode().compute();
		default:
			throw new IllegalStateException("No valid operator type : " + type);
		}
	}
	
	public void addNode(Node node) {
		if (getLeftNode() == null) {
			setLeftNode(node);
		}
		else if (getRightNode() == null) {
			setRightNode(node);
		}
		else {
			throw new IllegalStateException("All children nodes are already set");
		}
	}

	public OperatorType getType() {
		return type;
	}

	public Node getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
		leftNode.setParent(this);
	}

	public Node getRightNode() {
		return rightNode;
	}

	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
		rightNode.setParent(this);
	}

	@Override
	public String toString() {
		if (type == OperatorType.PARENTHESIS) {
			return "(" + leftNode.toString() + ")";
		}
		else {
			return leftNode.toString() + type.getCharacter() + rightNode.toString();
		}
	}
}
