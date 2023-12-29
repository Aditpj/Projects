/** Assassin Manager assignment
  * @author Adit Limbasia
  * @version 6/5/23
 */
// Serey Kosal helped me with printKillRing, which is similar graveyard. Liam helped me understand the process fo kill method and some sources also helped me understand the logic
import java.util.*;

public class AssassinManager {
   // Keep track of whos alive
   private AssassinNode killRing;
   // Keep track of whos dead
   private AssassinNode graveyard;
   /**
    * Constructor to populate kill ring linked list from input names.
	 * @param names list of names to add to kill ring linked list
    */
   public AssassinManager(List<String> names) {
      if (names.isEmpty()) {
         throw new IllegalArgumentException("The list cannot be empty.");      
      }
      for (int i = names.size() - 1; i >= 0; i--) {
			killRing = new AssassinNode(names.get(i), killRing);
		}
   }
   
   /** Prints the names of the assassins in the kill ring and how they are stalking */
   public void printKillRing() {
      AssassinNode stalk = killRing;
      while (stalk.next != null) {
         System.out.println("    "+ stalk.name + " is stalking " + stalk.next.name + ".");
         stalk = stalk.next; 
         }   
      if(stalk.next == null){
         System.out.println("    "+ stalk.name + " is stalking " + killRing.name +".");    
      }
   }
   
   /** Prints the names of the person killed and who they are killed by   */
   public void printGraveyard() {
      AssassinNode dead = graveyard;
      while (dead != null) {
        System.out.println("    " + dead.name + " was killed by " + dead.killer + ".");
        dead = dead.next;
      }
   }
   
   /** Checks if the kill ring contains an assassin with the specified name
   * @param the name of the assassin to check
   * @return true if the kill ring contains an assassin with the specified name if not its false
   */
   public boolean killRingContains(String name) {
      AssassinNode current = killRing;
      while (current != null) {
         if (current.name.toLowerCase().equals(name.toLowerCase()))return true;
         current = current.next;
         }
      return false;
   }
   
   /** Checks if the graveyard contains an assassin with the specified name
   * @param the name of the assassin to check
   * @return true if the kill ring contains an assassin with the specified name if not its false
   */
   public boolean graveyardContains(String name) {
      AssassinNode current = graveyard;
      while (current != null) {
         if (current.name.toLowerCase().equals(name.toLowerCase()))return true;
         current = current.next;
         }
      return false;
   }
   
   /** Checks if game is over
   * @return true if there is only one assassin left in the kill ring meaning the game is over if not its false
   */
   public boolean gameOver() {
      return killRing.next == null;   
   }
   
   /** Gets the winners name 
   * @return the name of the winner if the game is over else returns null
   */
   public String winner() {
      if (gameOver()) {
         return killRing.name;
      } else {
         return null;
      }
   }      
   /** Kills a player with the given name in the game.
   * @param name the name of the player to be killed
   * @throws IllegalStateException if the game is already over
   * @throws IllegalArgumentException if the given name is not in the kill ring
   */
   public void kill(String name) {
      AssassinNode latest = this.killRing;
      AssassinNode pior = this.killRing;
      if (gameOver()) {
         throw new IllegalStateException("The game is already over.");
      }
      if(!killRingContains(name)) {
			throw new IllegalArgumentException("The given name isn't in the kill ring");
		}

      while(latest.next != null) {  // this while loop traverses down the linked list
			if(name.toLowerCase().equals(latest.next.name.toLowerCase())) { 
				pior = latest.next; //referencing the linked list and updating it
				pior.killer = latest.name; // Gets killers name
				latest.next = latest.next.next; //updates the linked list so the node is pointing to the next next person 
				pior.next = this.graveyard; // updates the graveyard
				this.graveyard = pior; // adds the killers name to the graveyard so the print graveyard is updated
			}else {
				latest = latest.next; // goes the next name
			}
		}
      if(name.toLowerCase().equals(this.killRing.name.toLowerCase())) {
			pior = this.killRing; // goes to first node
			this.killRing = this.killRing.next; //goes to the second node which updates the victim
			pior.next = this.graveyard; 
			this.graveyard = pior;
			this.graveyard.killer = latest.name; //gets the killers name from graveyard
		} 
             
   }
}