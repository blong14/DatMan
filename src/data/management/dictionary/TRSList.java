package data.management.dictionary;

/**
 * Initially unsorted doubly linked list with Transpose Strategy (TRS) for ordering
 * 
 * Still needs some work to figure out about comparisons for keys and key generation
 * 
 * @author Ben Long
 *
 */
public class TRSList extends DMLinkedList {
	
	/**
	 * TRSNode models nodes in the TRSLinked list
	 * 
	 * @author Ben Long
	 *
	 */
	private static class TRSNode {
		
		/**Generic object stored in the node*/
		private Object value;
		
		/**Pointer to the previous node*/
		private TRSNode previous;
		
		/**Pointer to the next node*/
		private TRSNode next;
		
		/**
		 * TRSNode constructor
		 * 
		 * @param o Object to hold in the node
		 * @param p Previous node
		 * @param n Next node
		 */
		public TRSNode(Object o, TRSNode p, TRSNode n) {
			this.value = o;
			this.next = n;
			this.previous = p;
		}

		/**
		 * @return the current value stored in this node
		 */
		public Object getValue() {
			return this.value;
		}
		
		/**
		 * @return the next node in the list
		 */
		public TRSNode getNext() {
			return this.next;
		}

		/**
		 * @param n The next node to store in this node
		 */
		public void setNext(TRSNode n) {
			this.next = n;
		}

		/**
		 * @return The previous node in the list
		 */
		public TRSNode getPrevious() {
			return this.previous;
		}

		/**
		 * @param n The previous node to store in this node
		 */
		public void setPrevious(TRSNode n) {
			this.previous = n;
		}
		
		/**
		 * @return Simple string representation of this TRSNode
		 */
		@Override
		public String toString() {
			String prev = null, nex = null;
			if (previous == null) {
				prev = "null";
			} else {
				prev = "" + previous.getValue();
			}
			if (next == null) {
				nex = "null";
			} else {
				nex = "" + next.getValue();
			}
			
			return "Node [value=" + value + ", previous=" + prev + ", next=" + nex + "]";
		}
	}
	
	/**Dummy head pointer*/
	private TRSNode head = null;
	
	/**Dummy tail pointer*/
	private TRSNode tail = null;
	
	/**The size of the list*/
	private int size = 0;
	
	/**
	 * TRSList constructor. Initially constructs and empty list.
	 */
	public TRSList() {
		this.head = new TRSNode(null,null,null);
		this.tail = new TRSNode(null,this.head,null);
		this.head.setNext(this.tail);
	}

	/**
	 * Adds input to list
	 * 
	 * @param o
	 */
	@Override
	public void add(Input o) {
		traverseListAndAdd(this.head.getNext(),o);
	}
	
	/**
	 * The front of the list
	 * 
	 * @return The front Input in the linked list
	 * @throws EmptyListException
	 */
	@Override
	public Input front() throws EmptyListException {
		if (isEmpty()) {
			throw new EmptyListException("Empty List!");
		}
		return (Input) ((TRSNode) this.head.getNext()).getValue();
	}

	/**
	 * The end of the list
	 * 
	 * @return The end Input in the linked list
	 * @throws EmptyListException
	 */
	@Override
	public Input end() throws EmptyListException {
		if (isEmpty()) {
			throw new EmptyListException("Empty List!");
		}
		return (Input) (this.tail.getPrevious()).getValue();
	}

	/**
	 * @return If the list is empty or not.
	 */
	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	/**
	 * @return The size of the list
	 */
	@Override
	public int size() {
		return this.size;
	}

	/**
	 * Adds key:value pairs to the front of the list
	 * 
	 * @param o The key:value pair to add
	 */
	@Override
	public void addToFront(Input o) {
		addBetween(o,this.head,this.head.getNext());
	}

	/**
	 * Adds key:value pairs to the end of the list
	 * 
	 * @param o The key:value pair to add
	 */
	@Override
	public void addToEnd(Input o) {
		addBetween(o,this.tail.getPrevious(),this.tail);
	}

	/**
	 * Removes key:value pairs from the list
	 * 
	 * @param o The key:value pair to remove
	 * @throws EmptyListException
	 */
	@Override
	public void remove(Input o) throws EmptyListException {
		if (isEmpty()) {
			throw new EmptyListException("Empty List!");
		}
		
		TRSNode current = this.head.getNext();
		while(current.getValue() != null) {
			if (((Input)current.getValue()).equals(o)) {
				if (current.getPrevious() == null) {
					this.head.setNext((TRSNode) current.getNext());
				} else {
					(current.getPrevious()).setNext(current.getNext());
				}
				current = null;
				size--;
				return;
			}
			current = current.getNext();
		}
	}
	
	@Override
	public Input find(int key) {
		return traverseListAndFind(this.head,this.head.getNext(),key);
	}
	
	/**
	 * Adds key:value pairs in between two nodes
	 * 
	 * @param o
	 * @param p
	 * @param n
	 */
	private void addBetween(Input o, TRSNode p, TRSNode n) {
		TRSNode temp = new TRSNode(o,p,n);
		p.setNext(temp);
		n.setPrevious(temp);
		size++;
	}
	
	/**
	 * Traverse the list and Transpose key:value pairs if key in list
	 * 
	 * @param previous
	 * @param current
	 * @param key
	 * @return
	 */
	private Input traverseListAndFind(TRSNode previous, TRSNode current, int key) {
		if (current == this.tail) {
			return null;
		} else if (((Input)current.getValue()).getKey() == key) {
			TRSNode temp = current;
			if (previous != this.head) {
				(previous.getPrevious()).setNext(current);
				current.setPrevious(previous.getPrevious());
				previous.setNext(current.getNext());
				(current.getNext()).setPrevious(previous);
				current.setNext(previous);
				previous.setPrevious(current);
			} else {
				return (Input)temp.getValue();
			}
			return (Input)temp.getValue();
		} else {
			return traverseListAndFind(current, current.getNext(), key);
		}
	}
	
	/**
	 * Traverse the list determining if the key:value pair are already in the list
	 * If they are don't add. If they aren't add to the end of the list.
	 * 
	 * @param current
	 * @param o
	 */
	private void traverseListAndAdd(TRSNode current, Input o) {
		if (current == this.tail) {
			addToEnd(o);
		} else if (current.getValue().equals(o)) {
			return;
		} else {
			traverseListAndAdd(current.getNext(),o);
		}
	}
	
	/**
	 * String representation of all key:value pairs found in the list
	 */
	@Override
	public String toString() {
		if (isEmpty()) {return "\n\n\n";}
		TRSNode current = this.head.getNext();
		String s = "";
		while (current != this.tail) {
			s += ((Input)current.getValue()).getKey() + "    " + ((Input)current.getValue()).getValue() + "\n";
			current = current.getNext();
		}
		s += "\n\n";
		return s;
	}
}
