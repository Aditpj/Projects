/*
 * @author Adit Limbasia
 * ShoppingList
 * CS 145
 */
public class ShoppingList {
   /** Array field to store */
   private ShoppingItem [] items; 
   /** number of items in the list */
   private int size; 
   
   /** Constructs a new empty ShoppingList */
   public ShoppingList () { 
      items = new ShoppingItem[10];
      size = 0;
   }
   /**
   @return true if there are items in array
   */
   public boolean add (ShoppingItem newItem) {
      if (size >= 10) return false;
      else {
         items[size] = newItem;
         size++;
         return true;
      }  
   }
   /**
   @returns the total sum cost of all shopping items in this list
   */
   public double getTotalCost () {
      double sum=0;
      for (int i=0; i<size; i++) {
        sum += items[i].getCost();
      }
      return sum;
   }
   /** Counts the numbers of items in the array
   if there is more than 1 items then enters else
   */
   
   public String toString1() {
      String ShoppingList = "ShoppingList has " + size + " shopping items: ";
      for(int i=0; i < size; i++) {
         if (i == size - 1) {
            ShoppingList = ShoppingList + items[i].getQuantity()+ " "+ items[i].getName();
            }
         else {
            ShoppingList = ShoppingList + items[i].getQuantity() + " " + items[i].getName()+ ", ";
         }
      }
      return ShoppingList;
}
   /** 
   Find the item name in the array by checking the size
   @return null if nothing is in the array
   */
   public ShoppingItem searchByName (String itemName) {
      for (int i=0; i < size; i++) {
         if(itemName.equalsIgnoreCase(items[i].getName()))
            { return items[i]; } 
      }
      return null;
   }
}