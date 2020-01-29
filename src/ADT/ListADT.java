package ADT;

public class ListADT <T> implements IList<T>{
	private Node firstNode;
	private int numberOfEntries;
	
	public ListADT() {
		firstNode=null;
		numberOfEntries=0;
	}
	
	private Node getNodeAt(int givenPosition) {
		assert (firstNode != null) && (1 <= givenPosition) && (givenPosition <= numberOfEntries);
		Node currentNode = firstNode;
		
		for(int c = 1; c < givenPosition; c++) {
			currentNode = currentNode.getNextNode();
		}	
		assert currentNode != null;
		return currentNode;
		
	}
	@Override
	public T getEntry(int givenPosition) {
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			assert !isEmpty();
			return getNodeAt(givenPosition).getData();
		}
		else
			throw new IndexOutOfBoundsException("Illegal position");
	}

	@Override
	public T remove(int givenPosition) {
		T result = null;
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			assert !isEmpty();
			if(givenPosition == 1) {
				result = firstNode.getData();
				firstNode = firstNode.getNextNode();
			}
			else {
				Node nodeBefore = getNodeAt(givenPosition-1);
				Node nodeToRemove = nodeBefore.getNextNode();
				result = nodeToRemove.getData();
				Node nodeAfter = nodeToRemove.getNextNode();
				nodeBefore.setNextNode(nodeAfter);
			}
			numberOfEntries--;
			return result;
		}
		else
			throw new IndexOutOfBoundsException("Illegal position");
	}

	@Override
	public T replace(int givenPosition, T newEntry) {
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
				assert !isEmpty();
				Node desiredNode = getNodeAt(givenPosition);
				T originalEntry = desiredNode.getData();
				desiredNode.setData(newEntry);
			return originalEntry;
		}
		else
			throw new IndexOutOfBoundsException("Illegal position");
	}

	@Override
	public boolean clear() {
		firstNode=null;
		numberOfEntries=0;
		return isEmpty();
		
	}

	@Override
	public void add(T newEntry) {
		
		if(newEntry != null) {
		Node newNode = new Node(newEntry);
		if (isEmpty())
			firstNode = newNode;
		else {
			Node lastNode = getNodeAt(numberOfEntries);
			lastNode.setNextNode(newNode);
		}
		numberOfEntries++;
		}
		else 
			throw new IllegalArgumentException();
	}

	@Override
	public void add(int newPosition, T newEntry) {
		
		if((newPosition>=1) && (newPosition <= numberOfEntries + 1)) {
			Node newNode = new Node(newEntry);
			
			if(newPosition==1) {
				newNode.setNextNode(firstNode);
				firstNode = newNode;
			}
			else {
				Node nodeBefore = getNodeAt(newPosition-1);
				Node nodeAfter = nodeBefore.getNextNode();
				newNode.setNextNode(nodeAfter);
				nodeBefore.setNextNode(newNode);
			}
			numberOfEntries++;
		}
		else
			throw new IndexOutOfBoundsException("Illegal position");
	}

	@Override
	public boolean isEmpty() {
		boolean result;
		if(numberOfEntries == 0) {
			assert firstNode == null;
			result = true;
		}
		else {
			assert firstNode == null;
			result = false;	
		}
		return result;
	}

	@Override
	public T[] toArray() {
		T[] result = (T[]) new Object[numberOfEntries];
		int index=0;
		Node currentNode = firstNode;
		while((index<numberOfEntries) && (currentNode != null)) {
			result[index] = currentNode.getData();
			currentNode = currentNode.getNextNode();
			index++;
		}
		return result;
	}
	
	public boolean contains(T anEntry) {
		boolean found = false;
		Node currentNode = firstNode;
		
		while((!found) && (currentNode != null)) {
			if(anEntry.equals(currentNode.getData()))
				found = true;
			else
				currentNode = currentNode.getNextNode();
		}
		return found;
	}
	@Override
	public int getLength() {
		return numberOfEntries;
	}
	
	private class Node {
		
	private T data;
	private Node next;
	
	private Node(T dataPortion) {
		this(dataPortion,null);
	}
	private Node(T dataPortion, Node nextNode) {
		this.data = dataPortion;
		this.next = nextNode;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public Node getNextNode() {
		return next;
	}
	public void setNextNode(Node next) {
		this.next = next;
	}
	
	
	}

	public T getFirstElement() {
		return firstNode.getData();
	}
	

	

}
