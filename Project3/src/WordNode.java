/**
 * Represents a node in a linked list containing a word.
 * 
 * <p>This class encapsulates a word and a reference to the next node in the linked list.</p>
 * 
 * <p><strong>Note:</strong> Instances of this class are used in linked list data structures.</p>
 * 
 * @author Roshan Jahan
 */
public class WordNode {
	 /** The word stored in this node. */
	protected Word data;
	/** Reference to the next node in the linked list. */
	protected WordNode next;
	
	public WordNode (Word w) {
		data = w;
		next = null;
	}	
	 /**
     * Constructs a WordNode with the given word and initializes the next reference to null.
     * @param w the word to be stored in the node
     */
}
