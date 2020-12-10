
/**
 * A discounted item.
 */

public class DiscountedItem implements Item {
  
  public DiscountedItem(Item item, double discount) {
    this.item = item;
    this.discount = discount;
  }

  public double getPrice() {
    return item.getPrice() * (1 - discount / 100);
  }

  public String toString() {
    return item.toString() + " (Discount " + discount + "%)";
  }

  private Item item;
  private double discount;
}