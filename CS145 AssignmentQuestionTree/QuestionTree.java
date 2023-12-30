/** Final Project QuestionTree
  * Question Tree class
  * @author Adit Limbasia
  * @version 6/5/23
 */
 //Seray helped explained the play method
import java.util.*;
import java.io.*;

public class QuestionTree {
   // The overallRoot QuestionNode of the QuestionTree.
   private QuestionNode overallRoot;
   // The total number of games played.
   private int totalGames;
   // The number of games won. 
   private int gamesWon;
   // The UserInterface object used for interaction in the QuestionTree game.
   private UserInterface my;
  
  /** Constructor that has QuestionTree object with the given UserInterface.
  * The root node starts with Jedi as question
  * Starts the games and wins number to 0
  * @param ui the UserInterface to be used for interaction
  */
  public QuestionTree (UserInterface ui)
  {
   if (ui == null) {
      throw new IllegalArgumentException();
   }
    this.my = ui;
    overallRoot = new QuestionNode ("Jedi");
    totalGames = 0;
    gamesWon = 0;
  }
  
  /**
   * Plays a game in the QuestionTree.
   * Updates the games played
   * Call the recursive play method which updates the overallRoot node
   */
  public void play() {
   my.println("Play Game here");
   totalGames++;
   overallRoot = recursion(overallRoot);
  }
  
  /**
   * Recursively processes a binary tree of QuestionNode objects. 
   * @param root The root node of the binary tree.
   * @return The modified root node after the recursive processing.
   */
  private QuestionNode recursion(QuestionNode root) {  
   if (root.left == null && root.right == null) { // Guessing game is played
        my.print("Would your object happen to be " + root.data + "?");

        if (my.nextBoolean()) {
            my.println("I win!");
            gamesWon++;
        } else {
            // Player wins, new node and question are added
            my.print("I lose. What is your object?");
            String input = my.nextLine();
            my.println("Type a yes/no question to distinguish your item from " + root.data + ":");
            String newNode = my.nextLine();
            my.println("And what is the answer for your object?");
            boolean userInput = my.nextBoolean();
           if (userInput) {
               return new QuestionNode(newNode, new QuestionNode(input), root);
            } else {
               return new QuestionNode(newNode, root, new QuestionNode(input));
            }
        }
    } else {
        // Question is asked and processed
        my.println(root.data);
        if (my.nextBoolean()) {
            root.left = recursion(root.left);
        } else {
            root.right = recursion(root.right);
        }
    }
    return root;
} 
  /** Saves the current tree structure to a file using the provided PrintStream. 
  * @param output The PrintStream used to write the tree structure to a file.
  */    
  public void save(PrintStream output){
    my.println("Save the current tree here");
    save(output, overallRoot);
  }
   
   /** Recursively saves the current tree structure to a file using the provided PrintStream. 
   * @param output The PrintStream used to write the tree structure to a file.
   * @param node The current node being processed.
   */  
   private void save(PrintStream output, QuestionNode node) {
      if(node == null) return;
      
      if (node.left == null && node.right == null) { //Answer node is saved
         output.println("A:" + node.data);
      } else {
         // Question node is saved and children are processed
         output.println("Q:" + node.data);
         save(output, node.left);
         save(output, node.right);
      }
   }
  
  /** Loads a tree structure from a file using the provided Scanner
  * Sets it as the overall root of the current tree. 
  * @param input The Scanner used to read the file and retrieve the tree structure.
  */
  public void load(Scanner input){
    my.println("Save the current file here");
    overallRoot = helper(input);
  }
  
  /** Recursively constructs a tree structure by parsing the input file using the provided Scanner. 
  * @param input The Scanner used to read the input file.
  * @return The constructed QuestionNode representing the tree structure.
  */
  private QuestionNode helper(Scanner input) {
    if (!input.hasNextLine()) { // Base case: No more lines in the input file
      return overallRoot;
    } else {
        String look = input.nextLine(); // Converts the line into string format
        if(look.equals("A:")) { //Answer it created
         return new QuestionNode(look);
        } else if (look.startsWith("Q:")) { //Question node is created and children are processed
         QuestionNode left = helper(input); // Goes to check if theres a question or answers untell theres a leaf node for left side
         QuestionNode right = helper(input); // Goes to check if theres a question or answers untell theres a leaf node for right side
      }           
    }
    return overallRoot;     
  } 
  
  /** Return games played
  * @return number of games played
  */
  public int totalGames(){
    return 0;
  }
  
  /** Return games won
  * @return the number of games won
  */
  public int gamesWon(){
    return 0;
  }
  
}