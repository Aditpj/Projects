import java.util.*;

public class TestShoppingList {
   public static void main (String[] args) {
      ShoppingList list = new ShoppingList();
      list.add (new ShoppingItem ("Milk", 1, 0.99));
      boolean result = list.add (item);
      if (result) System.out.println (list);
      else System.out.println ("full List");
      
      Scanner console = new Scanner (System.in);
      int options;
      do {
      System.out.print ("Enter options 1-5: ");
      while (!console.hasNextInt()) {
         System.out.print ("Wrong input! enter options 1-5: ");
         console.next(); // discard the previous bad input
      }
      // when you are here, user input is int
      int options = console.nextInt();
      } while (option <1 || option >5);
   }
   // Option 3: Change Quantity 
      //
      if (null == list.searchByName (userInputName))
         // userInputName not found
      else 
         // userInputName is not found. we can change the quantity
}