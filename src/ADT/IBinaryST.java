package ADT;

public interface IBinaryST <T extends Comparable <? super T>>{

	public boolean contains(T entry);
	
	public T getEntry(T entry);
	
	public T add(T newEntry);
	
	public T remove(T entry);


}
