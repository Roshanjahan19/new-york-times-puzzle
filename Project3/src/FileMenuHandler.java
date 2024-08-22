

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *  
 * This class is the FileMenuHandler of the word puzzle project.
 * This class gives user options to open any file for reading and one to Quit the program.
 * It reads words from a text file, stores them in unsorted and sorted linked lists,
 * and then displays them using a graphical user interface (GUI).
 * @author Roshan Jahan
 */


public class FileMenuHandler implements ActionListener {
	 private PuzzleGUI puzzleGUI; // Reference to PuzzleGUI object
	    private String inputWord;

   
	    public FileMenuHandler(PuzzleGUI puzzleGUI) {
	        this.puzzleGUI = puzzleGUI;
	    }
	    /**
	     * Constructor for FileMenuHandler class.
	     * @param puzzleGUI the PuzzleGUI object to be associated with this FileMenuHandler
	     */
	    
   public void actionPerformed(ActionEvent event) {
      String  menuName;
      menuName = event.getActionCommand();
      if (menuName.equals("Open"))
         openFile( ); 
      else if (menuName.equals("Quit"))
         System.exit(0);
   } //actionPerformed
   /**
    * Handles actions performed by menu items.
    * @param event the ActionEvent object representing the user's action
    */
   
    private void openFile( ) {
       JFileChooser chooser;
       int          status;
       chooser = new JFileChooser( );
       status = chooser.showOpenDialog(null);
       if (status == JFileChooser.APPROVE_OPTION) 
          readSource(chooser.getSelectedFile());
       else 
          JOptionPane.showMessageDialog(null, "Open File dialog canceled");
    } //openFile
    /**
     * Opens a file chooser dialog for the user to select a file.
     */
  
    private void readSource(File chosenFile) {
       String chosenFileName = chosenFile.getAbsolutePath() ;
       TextFileInput inFile = new TextFileInput(chosenFileName);
       String words;
  
       inputWord = inFile.readLine();/** stores in the 7 letters to be used */
       SortedWordList newSortedList = new SortedWordList(); // Instantiate a new SortedWordList
       UnsortedWordList newUnsortedList = new UnsortedWordList(); // Instantiate a new UnsortedWordList

       
       while ((words = inFile.readLine()) != null) {
    	   try {
				Word word = new Word(words.trim()); 
				newUnsortedList.add(word); 
			} catch (IllegalWordException e) {
				System.out.println("Illegal word: " + e.getMessage());
			}////try/catch statement to catch IllegalWordException in the program
		}//while
       inFile.close(); // Close the file after reading from it
       
       puzzleGUI.updateData(newSortedList, inputWord, newUnsortedList);
    }
    /**
     * Reads the contents of the selected file and updates the GUI.
     * @param chosenFile the file selected by the user
     */
}