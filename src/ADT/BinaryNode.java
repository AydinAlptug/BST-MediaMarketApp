package ADT;

public class BinaryNode <T>{

	private T data;
	private BinaryNode <T> leftChild;
	private BinaryNode <T> rightChild;
	
	public BinaryNode() {
		this(null);
	}
	public BinaryNode(T dataPortion) {
		this(dataPortion,null,null);
	}
	public BinaryNode(T dataPortion, BinaryNode <T> newLeftChild, 
									 BinaryNode <T> newRightChild) {
		data = dataPortion;
		leftChild = newLeftChild;
		rightChild = newRightChild;
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public BinaryNode<T> getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(BinaryNode<T> leftChild) {
		this.leftChild = leftChild;
	}
	public BinaryNode<T> getRightChild() {
		return rightChild;
	}
	public void setRightChild(BinaryNode<T> rightChild) {
		this.rightChild = rightChild;
	}
	
	public boolean hasLeftChild() {
		return leftChild != null;
	}
	public boolean hasRightChild() {
		return rightChild != null;
	}
	
	public boolean isLeaf() {
		return (leftChild == null) && (rightChild == null);
	}
	
	public int getNumberOfNodes() {
		int leftNumber = 0;
		int rightNumber = 0;
		if(leftChild != null)
			leftNumber = leftChild.getNumberOfNodes();
		if(rightChild != null)
			rightNumber = rightChild.getNumberOfNodes();
		return 1 + leftNumber + rightNumber;
	}
	public int getHeight() {
		return getHeight(this);
	}
	public int getHeight(BinaryNode<T> node) {
		int height = 0;
		if(node != null)
			height = 1 + Math.max(getHeight(node.leftChild)
								,getHeight(node.rightChild)); 
		return height;
	}
	public BinaryNode<T> copy(){
		BinaryNode<T> newRoot = new BinaryNode<T>(data);
		if(leftChild != null)
			newRoot.setLeftChild(leftChild.copy());
		if(rightChild != null)
			newRoot.setRightChild(rightChild.copy());
		return newRoot;
	}
	
}
