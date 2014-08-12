package data.management.dictionary;

/**
 * The Input class models input key:values to be entered into a linked list (or other data structure)
 * 
 * @author Ben Long
 */
public class Input {

	/**The key that identifies this input*/
	private int key;
	
	/**The value of the input*/
	private Object value;

	/**
	 * Input constructor
	 * 
	 * @param k The key of the input
	 * @param v The value of the input
	 */
	public Input(int k, String v) {
		this.key = k;
		this.value = v;
	}
	
	/**
	 * @return The unique key for the input
	 */
	public int getKey() {
		return key;
	}

	/**
	 * Sets the unique key
	 * 
	 * @param key
	 */
	public void setKey(int key) {
		this.key = key;
	}

	/**
	 * @return The value of the current input
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * Sets the value for this input
	 * 
	 * @param value
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	/**
	 * Determines if an object is equal to this Input object
	 * 
	 * @param The object to compare to this Input
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Input) {
			if (this.key == ((Input)o).getKey()) {
				return true;
			}
			return false;
		}
		return false;
	}

	/**
	 * Returns the contents of the input
	 */
	@Override
	public String toString() {
		return "Input [key=" + key + ", value=" + value.toString() + "]";
	}
}