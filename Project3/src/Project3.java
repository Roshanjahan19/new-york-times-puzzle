import java.awt.AWTException;


/**
 *  
 * This class is the main method of the word puzzle project.
 * It reads words from a text file, stores them in unsorted and sorted linked lists,
 * and then displays them using a graphical user interface (GUI).
 * @author Roshan Jahan
 */

public class Project3 {
	
	public static void main(String[]  args) throws AWTException {
		
		TextFileInput textfile = new TextFileInput("wordPuzzle.txt");/** file reads the .txt file */ 
		String inputWord = textfile.readLine();/** stores in the 7 letters to be used */
		
		UnsortedWordList unsortedList = new UnsortedWordList();
        SortedWordList sortedList = new SortedWordList();
        		
        String line;
        while ((line = textfile.readLine()) != null) { // Read each line from the text file
        	try {
				Word word = new Word(line.trim()); 
				unsortedList.add(word); 
			} catch (IllegalWordException e) {
				System.out.println("Illegal word: " + e.getMessage());
			}//try/catch statement to catch IllegalWordException in the program
		}
        textfile.close(); // Close the file after reading from it
        
        // Update GUI with sorted list contents
        PuzzleGUI puzzleSorted = new PuzzleGUI(sortedList,inputWord,unsortedList);
        puzzleSorted.setVisible(true);
        
		

	}
}