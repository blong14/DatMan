package data.management.dictionary;

/**
 * Simple API for Linked List implementations
 * 
 * @author Ben Long
 *
 */
public abstract class DMLinkedList {
		
	public abstract void add(Input o);
	
	public abstract void addToFront(Input o);
	
	public abstract void addToEnd(Input o);
	
	public abstract Input find(int key) throws EmptyListException;
	
	public abstract Input front() throws EmptyListException;
	
	public abstract Input end() throws EmptyListException;
	
	public abstract void remove(Input o) throws EmptyListException;
	
	public abstract boolean isEmpty();
	
	public abstract int size();
}
