/**
 * Represents a sorted list of words.
 * 
 * <p>This class extends the WordList class and provides methods to add words to the list in alphabetical order.</p>
 * 
 * <p><strong>Note:</strong> Instances of this class maintain the words in sorted order.</p>
 * 
 * <p><strong>Usage:</strong> To add a word to the list in alphabetical order, call the {@link #add(Word)} method.</p>
 * <p><strong>Implementation Note:</strong> Adding a word to the list is done by traversing the list to find the appropriate
 * position for the new word and then inserting it into the list.</p>
 * 
 * <p><strong>Assumption:</strong> The compareTo method of the Word class is used to determine the alphabetical order
 * of words.</p>
 * 
 * @author Roshan Jahan
 */
public class SortedWordList extends WordList {
    
    public SortedWordList() {
        super();
    }
    /**
     * Constructs an empty SortedWordList by calling the superclass constructor.
     */
    public void add(Word wrd) { //add new node to the list in alphabetically 
        WordNode newNode = new WordNode(wrd);
        
        /** If the list is empty or the new word comes before the first actual word */
        if (length == 0 || wrd.getWord().compareTo(first.next.data.getWord()) < 0) {
            newNode.next = first.next; // Set the new node's next to the current first node's next
            first.next = newNode; // Update the first node's next to point to the new node
            if (length == 0) {
                last = newNode; // If the list was empty, update the last node reference
            }
            length++; // Increment the length of the list
            return;
        }
        
        WordNode current = first.next; // Start from the first actual node
        WordNode previous = first; // Initialize previous to the dummy node
        
        // Traverse the list until finding the appropriate position for the new word
        while (current != null && wrd.getWord().compareTo(current.data.getWord()) > 0) {
            previous = current; //the compareTo method uses uniCode value to determine where to place the mode
            current = current.next;
        }
        
        /** Insert the new word node into the list */
        newNode.next = current; // Set the new node's next to the current node
        previous.next = newNode; // Update the previous node's next to point to the new node
        
        // Update the last node reference if the new node is added at the end
        if (current == null) {
            last = newNode;
        }
        
        length++; /** Increment the length of the list */
    
    }
}