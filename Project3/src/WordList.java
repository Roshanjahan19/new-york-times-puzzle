/**
 * Represents an abstract data structure for storing words in a linked list.
 * 
 * <p>This class provides methods to manipulate the list such as appending words and getting the length.
 * </p>
 * 
 * <p><strong>Note:</strong> This class is abstract and must be subclassed to provide a concrete implementation.</p>
 * 
 * @author Roshan Jahan
 */

public abstract class WordList {
	
	WordNode ln = new WordNode(null);
	/** The first node of the linked list. */
	   protected WordNode first; //protected instance variables
	   /** The last node of the linked list. */
	   protected WordNode last;
	   /** The length of the linked list. */
	   protected int length;

	   public WordList(){
		   first = ln;//first node is a dummy node
		   
		   last = ln;//last node is a dummy node
		   
		   length =0;//initially, length of the linked list will be 0
	   }
	   /**
	     * Constructs an empty WordList with a dummy node as the first and last nodes.
	     * Initially, the length of the linked list will be 0.
	     */
	   
	   public int getLength() {
			return length;//method to get the length of the linked list
		}
	   /**
	     * Gets the length of the linked list.
	     *
	     * @return the length of the linked list
	     */
	   
	   public void append(Word s) {//an append method to add new word at the end of the word linked list
		   
		  WordNode n = new WordNode(s);//new node with a new word in it
		 
	        last.next = n;
	        
	        last = n;
	        
	        length++;
	    }

	    /**
	     * Appends a word to the end of the word linked list.
	     *
	     * @param s the word to be appended
	     */
	   }
