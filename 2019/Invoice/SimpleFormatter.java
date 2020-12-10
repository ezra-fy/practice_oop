/**
 * A simple invoice formatter.
 */

public class SimpleFormatter implements InvoiceFormatter {
  
  public String formatHeader() {
    total = 0;
    return "INVOICE\n=====\n\n";
  }

  public String formatItem(Item item) {
    total += item.getPrice();
    
    return (String.format("%s: %.2f\n", item.toString(), item.getPrice()));
  }

  public String formatFooter() {
    return (String.format("\n\nTOTAL DUE: €%.2f\n", total));
  }

  private double total;
}