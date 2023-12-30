 /*
 * @author Adit Limbasia
 * ShoppingClient
 * CS 145
 */
import java.util.*;
public class ShoppingClient {
   static Scanner input = new Scanner(System.in);
   // Do while for the menu and makes sure input is valid   
   public static void main (String[] args) {
      ShoppingList list = new ShoppingList();

      String option;
      do {
          option = menu();
          
          if (option.equals("1")) {
            menu();
          }
          
         else if (option.equals("2")) {
             addItem(list); 
          } 
          
        else if (option.equals("3")) {
          changeQuantity(list);
        } 
          // displays the list and total price
          else if (option.equals("4")) {
            System.out.println(list.toString1());
            double cost = list.getTotalCost();
            System.out.printf("The total cost is: %.2f \n", cost);
          } 
       }
       //Exits the program
    while (!option.equals("5")); {
      System.out.println("Have a nice day M'kay");
    }
}
      //Displays the menu by taking input
      public static String menu() {
        String input;
        Scanner console = new Scanner(System.in);
        System.out.println("1. Display the menu");
        System.out.println("2. Add a shopping item");
        System.out.println("3. Change the quantity of the item in the shopping list");
        System.out.println("4. Display the shopping list");
        System.out.println("5. Exit M'kay");
        System.out.print("Choose the options 1 through 5: ");
        input = console.next();
        return input;
    }
    //Asks the user for String then quantity then price checking if there is valid inputs then see if the list is full before adding
    public static void addItem(ShoppingList list) {
      System.out.print("Enter the name of the item you want to add: ");
        String item = input.next();

        System.out.print("Enter the Quantity: ");
        while (!input.hasNextInt()) {
         System.out.println("Invalid Input! Enter the Quantity: ");
         input.next();
        }
        int quantity = input.nextInt();
        System.out.print("Please Enter The Price: ");
        while (!input.hasNextDouble()) {
         System.out.println("Invalid Input! Enter a decimal Price: ");
         input.next();
        }
        double price = input.nextDouble();
        boolean add = list.add(new ShoppingItem(item, quantity, price));
        if (!add){
          System.out.println ("List is full"); 
        }
    } 
   // changes the quantity by taking in inputs
   public static void changeQuantity(ShoppingList list) {
         System.out.print("What item are you looking to change: ");
         String user = input.next();
         ShoppingItem find = list.searchByName(user);
         if(find == null){
            System.out.println("The item you entered is not in the list");
         }
         else {
          System.out.print("What is the new quantity of the item: ");
          int newItem = input.nextInt();
          find.setQuantity(newItem);
         }
    } 
}