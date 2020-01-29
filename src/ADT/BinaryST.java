package ADT;
public class BinaryST <T extends Comparable<? super T>> implements IBinaryST <T>{

	private BinaryNode<T> root; ///////
	
	public BinaryST() {
		this(null);
	}
	public BinaryST(T rootData) {
		root = new BinaryNode<>(rootData);
	}
	public BinaryST(T rootData, BinaryST <T> leftTree, BinaryST <T> rightTree) {
		privateSetTree(rootData,leftTree,rightTree);
	}
	public void setTree(T rootData) {
		root = new BinaryNode<>(rootData);
	}
	public void setTree(T rootData,IBinaryST<T> leftTree,IBinaryST<T> rightTree) {
		privateSetTree(rootData,(BinaryST<T>)leftTree,(BinaryST<T>)rightTree);
	}
	private void privateSetTree(T rootData, BinaryST <T> leftTree,
								BinaryST <T> rightTree) {
		root = new BinaryNode<>(rootData);
		if(leftTree != null)
			root.setLeftChild(leftTree.root.copy());
		if(rightTree != null)
			root.setRightChild(rightTree.root.copy());
		
	}
	public boolean isEmpty() {
		return root == null;
	}
	public T getRootData() {
		T rootData = null;
		if(root !=null)
			rootData = root.getData();
		return rootData;
	}
	public void clear() {
		root = null;
	}
	public T getEntry(T entry) {
		return findEntry(getRootNode(),entry);
	}	
	private T findEntry(BinaryNode<T> rootNode, T entry) {
		T result = null;
		if(rootNode!=null) {
			T rootEntry = rootNode.getData();
			if(entry.equals(rootEntry))
				result = rootEntry;
			else if(entry.compareTo(rootEntry)<0)
				result = findEntry(rootNode.getLeftChild(), entry);
			else
				result = findEntry(rootNode.getRightChild(), entry);
		}
		return result;	
	}
	public boolean contains(T entry) {
		return getEntry(entry) != null;
	}
	@Override
	public T add(T newEntry) {
		T result = null;
		if(isEmpty())
			setRootNode(new BinaryNode<>(newEntry));
		else
			result = addEntry(getRootNode(),newEntry);
		return result;
	}
	private BinaryNode<T> getRootNode() {
		return root;
	}
	protected void setRootNode(BinaryNode<T> rootNode) {
		root =  rootNode;
	}
	protected void setRootData(T rootData) {
		root.setData(rootData);
	}
	private T addEntry(BinaryNode<T> rootNode,T newEntry) {
		assert rootNode != null;
		T result = null;
		int comparison = newEntry.compareTo(rootNode.getData());
		if(comparison == 0) {
			result = rootNode.getData();
			rootNode.setData(newEntry);
		}
		else if(comparison<0) {
			if(rootNode.hasLeftChild()) {
				result = addEntry(rootNode.getLeftChild(),newEntry);
			}
			else {
				rootNode.setLeftChild(new BinaryNode<> (newEntry));
			}
		}
		else {
			assert comparison > 0;
			if(rootNode.hasRightChild()) 
				result = addEntry(rootNode.getRightChild(), newEntry);
			
			else
				rootNode.setRightChild(new BinaryNode<> (newEntry));
		}
		return result;
			
	}

	public ListADT<T> toList() {
	    ListADT<T> result = new ListADT<T>();    
	    toListHelp(root, result);
	    return result;
	}
	
	private void toListHelp(BinaryNode<T> node, ListADT<T> result) {
	    if (node == null) {
	        return;
	    }
	    toListHelp(node.getLeftChild(), result); 
	    result.add(node.getData());
	    toListHelp(node.getRightChild(), result); 
	}
	
	public T[] toArray() {
		T[] array = (T[]) new Object[16];
		toArrayHelp(root,array,0);
		return array;
	}
	public void toArrayHelp(BinaryNode<T> node, T[] array, int i) {
		if(node == null)
			return;
		toArrayHelp(node.getLeftChild(), array,i); 
	    array[i] = node.getData();
	    i++;
	    toArrayHelp(node.getRightChild(), array,i);
	}
	
	@Override
	public T remove(T entry) {
		return removeEntry(root,entry,null).getData();
	}
	private BinaryNode<T> removeEntry(BinaryNode<T> rootNode,T entry, BinaryNode<T> oldEntry ){
		if(rootNode != null) {
			T rootData = rootNode.getData();
			int comparison = entry.compareTo(rootData);
			if(comparison==0) {
				oldEntry.setData(rootData);
				rootNode = removeFromRoot(rootNode);
			}
			else if (comparison<0) {
				BinaryNode<T> leftChild = rootNode.getLeftChild();
				BinaryNode<T> subtreeRoot = removeEntry(leftChild,entry,oldEntry);
				rootNode.setLeftChild(subtreeRoot);
			}
			else {
				BinaryNode<T> rightChild = rootNode.getRightChild();
				rootNode.setRightChild(removeEntry(rightChild,entry,oldEntry));
			}
		}
		return rootNode;
	}
	private BinaryNode<T> removeFromRoot(BinaryNode<T> rootNode){
		if(rootNode.hasLeftChild() && rootNode.hasRightChild()) {
			BinaryNode<T> leftSubtreeRoot = rootNode.getLeftChild();
			BinaryNode<T> largestNode = findLargest(leftSubtreeRoot);
			
			rootNode.setData(largestNode.getData());
			rootNode.setLeftChild(removeLargest(leftSubtreeRoot));
		}
		else if(rootNode.hasRightChild())
			rootNode = rootNode.getRightChild();
		else
			rootNode = rootNode.getLeftChild();
			return rootNode;
	}
	private BinaryNode<T> findLargest(BinaryNode<T> rootNode){
		if(root.hasRightChild())
			rootNode = findLargest(rootNode.getRightChild());
		return rootNode;
	}
	private BinaryNode<T> removeLargest(BinaryNode<T> rootNode){
		if(rootNode.hasRightChild()) {
			BinaryNode<T> rightChild = rootNode.getRightChild();
			rightChild = removeLargest(rightChild);
			rootNode.setRightChild(rightChild);
		}
		else
			rootNode = rootNode.getLeftChild();
		return rootNode;
	}

	
}
