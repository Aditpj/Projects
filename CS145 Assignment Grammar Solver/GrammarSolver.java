/** Grammar Solver
  * GrammarSolver Assignment
  * @author Adit Limbasia
  * @version 5/18/23
 */
import java.util.*;

public class GrammarSolver {
   /**It is used to store the grammar rules*/
   private TreeMap <String, String[]> termMap; 
   
   /** Constructs a GrammarSolver object with the given list of rules.
   * @param rules the list of rules representing the grammar
   * @throws IllegalArgumentException if the rules list is empty
   */
   public GrammarSolver(List<String> rules) {
      if((rules.size()==0)|| rules.isEmpty()){
         throw new IllegalArgumentException();
      }
      termMap = new TreeMap<>();
      for(String word: rules) {
         word = word.trim();
         String[] splitWord = word.split("::=");
         String[] s2Word = splitWord[1].split("[|]");
         for(int i=0; i<2; i++) {
            splitWord[i] = splitWord[i].trim();
         }
       termMap.put(splitWord[0], s2Word);
      }
   }
   /** Checks if the GrammarSolver contains a given symbol.
   * @param symbol the symbol to be checked
   * @return true if the symbol is contained in the GrammarSolver, false otherwise
   * @throws IllegalArgumentException if the symbol is an empty string
   */
   public boolean contains(String symbol) {
      symbol = symbol.trim();
     
      if(symbol == null) {
         throw new IllegalArgumentException();
      }
      else{
         return termMap.containsKey(symbol);
      }
   }
   /** This method will return a Set of String which contains all the rules that corresponds to the non-terminal name
    * @return This will return the set of rules related to the non-terminal name
    */
    public Set<String> getSymbols(){
     return termMap.keySet();
    }
    
    /**Generates a string based on the given symbol using the grammar rules.
    * @param symbol the symbol to generate a string for
    * @return the generated string
    * @throws IllegalArgumentException if the symbol is null or an empty string
    */
    public String generate (String symbol) {
      String trimSymbol = symbol.trim();
      if((trimSymbol.length()==0)||(trimSymbol == null)){
         throw new IllegalArgumentException();
      }
      if(!contains(trimSymbol)){
         return trimSymbol;
      }
      Random rand = new Random();
      String empty="";
      String[] word = termMap.get(trimSymbol);
      int holdRand = rand.nextInt(word.length);
      String[] randWord = word[holdRand].split("[ \t]+");
      for(String term: randWord){ 
         if(!contains(term)){
            empty+=" "+term;
         } 
         else{
            empty+=generate(term)+ " ";
         }
      }
      return empty.trim();
   }
}