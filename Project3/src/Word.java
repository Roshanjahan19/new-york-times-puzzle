/**
 * Represents a word.
 * 
 * <p>This class encapsulates a word as a string and provides methods to access it.</p>
 * 
 * <p><strong>Note:</strong> Instances of this class are immutable.</p>
 * 
 * @author Roshan Jahan
 */

public class Word {
	
	 /** The word stored as a string. */
	private String word; //instance variable of type String

    public Word(String wrd) throws IllegalWordException { //sets the instance variable to parameter variable
    	 if (!wrd.matches("[a-z]+")) {
             throw new IllegalWordException("Word contains non-lowercase characters: " + word);
         } // A Word is illegal if it doesn’t contain all lowercase letters
    	 
    	 word = wrd;
    }
    /**
     * Constructs a Word object with the given word. 
     * @param wrd the word to be stored
     */

    public String getWord() {//get method to get the private instance variable
        return word;
    }
    /**
     * Gets the word stored in this Word object. 
     * @return the word stored in this object
     */
}
