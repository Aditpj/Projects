 /*
 * @author Adit Limbasia
 * ShoppingItem
 * CS 145
 */
public class ShoppingItem {
   /** Name of the shopping item */
   private String name; 
   /** quantity */
   private int quantity; 
   /**price per unit */
   private double price; 
   
   /** Construct and initialize ShoppingItem at the specified (name, quantity,pricePerUnit) location
   * @param name refers to String name of the newly constructed ShoppingItem
   * @param quantity refers to int refers of the newly constructed ShoppingItem
   * @param pricePerUnit refers to double pricePerUnit of the newly constructed ShoppingItem
   */
   public ShoppingItem (String name, int quantity, double pricePerUnit) {
      this.name = name;
      this.quantity = quantity;
      this.price = pricePerUnit;
   }
   
   
   /**
   @return the name of this item
   */
   public String getName() {
      return name;
   }
   
   /** 
   @return quantity and name of this item
   */
   @Override
   public String toString () {
      return quantity + " " + name;
   }
   
   /**
   @return the total cost of this item in its given quantity 
   */
   public double getCost() {
      return quantity * price;
   }
   
   /** @return the quantity */
   public int getQuantity() {
      return quantity;
   }
   
   /** sets quantity to this object to the specified int value
   * @param quantity to this quantity to the new quantity
   */
   public void setQuantity(int quantity) {
      this.quantity = quantity;
   }
}
