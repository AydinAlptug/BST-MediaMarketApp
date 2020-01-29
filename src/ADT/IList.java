package ADT;

public interface IList <T> {

	public T getEntry(int givenPosition);
	
	public T remove(int givenPosition);
	
	public T replace(int givenPosition, T newEntry);
	
	public boolean clear();
	
	public void add(T newEntry);
	
	public void add(int givenPosition, T newEntry);
	
	public boolean isEmpty();
	
	public T[] toArray();
	
	public int getLength();	
	
	public boolean contains(T anEntry);
	
}
