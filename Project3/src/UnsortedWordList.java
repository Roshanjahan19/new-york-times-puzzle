/**
 * Represents an unsorted list of words.
 * 
 * <p>This class extends the WordList class and provides methods to add words to the list in an unordered manner
 * and check if a word is contained in the list.</p>
 * 
 * <p><strong>Note:</strong> Instances of this class maintain the insertion order of words.</p>
 * 
 * <p><strong>Usage:</strong> To add a word to the end of the list, call the {@link #add(Word)} method.
 * To check if a word is contained in the list, call the {@link #contains(Word)} method.</p>
 *  
 * @author Roshan Jahan
 */
public class UnsortedWordList extends WordList{

	public UnsortedWordList() {
		super();
	}
	 /**
     * Constructs an empty UnsortedWordList by calling the superclass constructor.
     */
	public void add(Word s) {// add a new node to the list unordered
		append(s);
	}
	/**
     * Adds a word to the end of the list by calling the append method in the superclass.
     * 
     * @param s the word to be added to the list
     */
	public boolean contains(Word target) {
		WordNode p = first.next; // Start from the first node of the list

			while (p != null) { // Traverse until the end of the list
					if (p.data.getWord().equalsIgnoreCase(target.getWord())) { // Check if the current node contains the target word
						return true; // If found, return true
					}
				p = p.next; // Move to the next node
		   }	

		return false; // If not found, return false
	}
/**
 * Checks if the list contains a specific word.
 * 
 * @param target the word to be searched for in the list
 * @return true if the word is contained in the list, otherwise false
 */
}