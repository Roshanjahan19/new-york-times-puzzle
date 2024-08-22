
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Represents a graphical user interface (GUI) for a word puzzle game.
 * 
 * <p>This class extends JFrame and implements ActionListener to handle button events.</p>
 * 
 * <p>The user can input words in a text field and earn points based on correct guesses.</p>
 * 
 * <p><strong>Note:</strong> The game displays 7 letters, and the user must input words containing those letters.</p>
 * 
 * <p><strong>Usage:</strong> Create an instance of PuzzleGUI with a SortedWordList, an input string containing 7 letters, 
 * and an UnsortedWordList. The user can input words in the text field and earn points based on correct guesses.</p>
 * <p><strong>Implementation Note:</strong> The class uses a TextArea to display the 7 letters and a separate TextArea to display the guessed words.</p>
 * 
 * <p><strong>Assumption:</strong> The game logic assumes that the user inputs words containing the letters displayed, and points are awarded accordingly.</p>
 * 
 * <p><strong>Author:</strong> Roshan Jahan</p>
 */

public class PuzzleGUI extends JFrame implements ActionListener{//inherits JFframe and implements ActionListener to listen to events
	
	private static final long serialVersionUID = 1L;
	
	private Container myContentPane;//instance variables
	private int point = 0;
	private TextArea pTextArea;
	private TextArea myTextArea;
	private String userInp;//user-input
	private JLabel pointsLabel;
	private String input;//7 letters from file
	private SortedWordList sortedList;
	private UnsortedWordList unsortedList;
	
	public PuzzleGUI(SortedWordList sorted,String i,UnsortedWordList unsorted) {
	 	input = i; //sets values property of input to input of the current this object
        sortedList = sorted;
        unsortedList = unsorted;

		  setTitle("Word Puzzle");// set title of GUI

	        JButton button = new JButton("Guess");// Create button via JButton
	        button.addActionListener(this);//addActionListener will allow button to listen to 'clicks'
	        
	        myContentPane = getContentPane();
	        myContentPane.setLayout(new BorderLayout()); // Set BorderLayout for the content pane

	        TextArea myTextArea = new TextArea(input);// Create text areas, one to display the 7 letters and one to show the output
	        myTextArea.setEditable(false);//set editable to false so user can't edit the textarea
	        this.myTextArea = myTextArea;
	        pTextArea = new TextArea();//this one displays the solutions
	        pTextArea.setEditable(false);
	       
	        JPanel textAreaPanel = new JPanel(new GridLayout(1, 2)); // Create panel for the text areas with GridLayout
	        textAreaPanel.add(myTextArea);//add the 7 letters to the left side of the panel
	        textAreaPanel.add(pTextArea);//add empty textarea the right side of the panel
	        

	        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Create panel for the button with FlowLayout to center the button
	        buttonPanel.add(button); // Add button to the buttonPanel
	        buttonPanel.setPreferredSize(new Dimension(100, 50)); // Set the size of the button panel

	        
	        pointsLabel = new JLabel("Points: " + point);//create label to display the score of the player
	        JPanel pointPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));//create panel to add the label
	        pointPanel.add(pointsLabel);//add the label to the panel
	        
	        
	        // Add panels to the content pane
	        myContentPane.add(textAreaPanel, BorderLayout.CENTER);
	        myContentPane.add(buttonPanel, BorderLayout.SOUTH);
	        myContentPane.add(pointPanel, BorderLayout.NORTH);

	        //add menu 
	        createMenu();
	     
	     // Set the settings of the JFrame
	        setSize(700, 400); 
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }//PuzzleGUI constructor  
	/**
     * Constructs a PuzzleGUI with the specified SortedWordList, input letters, and UnsortedWordList.
     * 
     * @param sorted the sorted word list
     * @param i the input letters
     * @param unsorted the unsorted word list
     */
	 
	
	private void createMenu( ) {
		   JMenuBar menuBar  = new JMenuBar();
		   JMenu fileMenu = new JMenu("File");
		   JMenuItem item;
		   FileMenuHandler fmh  = new FileMenuHandler(this);
		   item = new JMenuItem("Open"); 
		   item.addActionListener( fmh );
		   fileMenu.add( item );
		   fileMenu.addSeparator(); 
		   item = new JMenuItem("Quit"); 
		   item.addActionListener( fmh );
		   fileMenu.add( item );
		   setJMenuBar(menuBar);
		   menuBar.add(fileMenu);
		} //createMenu
	
	@Override
	public void actionPerformed(ActionEvent e) {//method to performed when button is clicked
		  userInp =  JOptionPane.showInputDialog(null, "Type in a word");//pops up a JOptionPane to get user input
		// Get the created dialog

		  addInput(userInp);//calls the method addInput with userinp as a parameter
	}//actionPerformed
	
	
	public void addInput(String w) {
	    if (isValid(w)) { // Pass user input to isValid method
	        Word userword = new Word(w);//creates a object of Word with user-input argument
	        if (unsortedList.contains(userword)) {//if unsortedlist contains user-input
	  
	            if (w.length() == input.length()) {//if user-input used all the letters from subject letters 
	                point += 3;//that is equal 3 points if the lengths are same (meaning user used all the letters)
	            } 
	            	else {
	            		point++;//else it is worth 1 point
	            	}
	            sortedList.add(userword);//add correctly guessed word to sorted list
	            updateTextArea();//append the new word to the list
	            updatePointsLabel();//update points to show current score
	           
	            if (sortedList.getLength()== ((unsortedList.getLength()))) {
	                 // All words are guessed, player wins
	            	Point location = new Point(200, 400); // Specify the desired coordinates
	            	JOptionPane optionPane = new JOptionPane("You have guessed all the words on the solutions list •ᴗ• !!!", JOptionPane.INFORMATION_MESSAGE);
	            	JDialog dialog = optionPane.createDialog("Congratulations!");
	            	dialog.setLocation(location);
	            	dialog.setVisible(true);
	            	
	                 // Ask if the player wants to play again
	                 int option = JOptionPane.showConfirmDialog(null, "Would you like to play again?", "Play Again", JOptionPane.YES_NO_OPTION);
	                 if (option == JOptionPane.YES_OPTION) {
	                     // Reset game and play again
	                     resetGame();
	                 } else {
	                     // Exit game
	                     System.exit(0);
	                 }
	             }
	        }
	        
	        
	        	else {
	            JOptionPane.showMessageDialog(null, "Your word is not on the list ;<");// Display message if the word is not found in the list
	        	}
	    } 
	    
	    	else {
	    		JOptionPane.showMessageDialog(null, "Used a letter that is not one of the seven letters given Or did not include the first character of the subject letters in the guessed word!!");// Display message if isvalid returns false
	    	}
	}//addInput
	/**
     * Adds the user's input to the list of words and updates the points.
     * 
     * @param w the word to be added
     */

	public boolean isValid(String userInp) { // Receive user input as an argument
		
		   if (userInp.equalsIgnoreCase("stop")) { //string method string.equalsIgnoreCase to stop the pop-up
               System.exit(0);
           }
		
	    if (userInp == null || userInp.length() < 5) {
	        JOptionPane.showMessageDialog(null, "Invalid Input! Must enter a word of 5 or more letters!"); 
	    }
	    
	    userInp = userInp.toLowerCase(); // Convert user input to uppercase for case insensitive comparison
	    
	  for (int i = 0; i < userInp.length(); i++) {
	        if (!input.contains(String.valueOf(userInp.charAt(i))) ||!userInp.contains(String.valueOf(input.charAt(0))) ) {
	            return false; // Return false if a character is not found among the given letters or if the first letter of the subject letters is not found in the user input
	        }
	 }
	  
	  return true; // Return true if a user input is found among the given letters
	}//isValid
	 /**
     * Checks if the user's input is valid.
     * 
     * @param userInp the user's input
     * @return true if the input is valid, false otherwise
     */
	
	public void updatePointsLabel() {
	    pointsLabel.setText("Points: " + point);//uses setText to update points when user gets a word correct
	}//updatePointsLabel
	/**
     * Updates the points label to display the current score.
     */
	
	public void updateTextArea() {//updates text to put them in alphabetical order
	    WordNode current = sortedList.first.next;
	    StringBuilder sb = new StringBuilder();
	    while (current != null) {
	        if (current.data != null) { // Add a null check
	            sb.append(current.data.getWord()).append("\n");//add the text 
	        }
	        current = current.next;
	    }
	    pTextArea.setText(sb.toString());
	}//updateTextArea
	  /**
     * Updates the text area to display the guessed words in alphabetical order.
     */
	
	public void updateData(SortedWordList sortedList, String inputWord, UnsortedWordList unsortedList) {
	    this.sortedList = sortedList;
	    this.input = inputWord;
	    this.unsortedList = unsortedList;
	    resetPoints();
	    myTextArea.setText(inputWord);
	    updateTextArea();
	}
	public void resetPoints() {
	    point = 0; // Set points to 0
	    updatePointsLabel(); // Update the points label to display the reset score
	}
	private void resetGame() {
	    // Reset points to 0
	    point = 0;
	    // Clear guessed words list
	    sortedList = new SortedWordList();
	    // Update UI
	    updatePointsLabel();
	    resetTextArea();
	}
	 public void resetTextArea() {
	        pTextArea.setText(""); // Clear the text area
	    }
}


