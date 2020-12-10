import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * An invoice for a sale, consisting of items.
 */

public class Invoice {

  public Invoice() {
    items = new ArrayList<Item>();
    listeners.setListeners(new ArrayList<ChangeListener>());
  }
  
  public Invoice(ArrayList<Item> initialItems) {
    items = initialItems;
    listeners.setListeners(new ArrayList<ChangeListener>());
  }
  
  public void addItem(Item item) {
    items.add(item);
    // invoice has been changed
    ChangeEvent event = new ChangeEvent(this);
    for (ChangeListener listener : listeners.getListeners())
      listener.stateChanged(event);
  }

  // Add a change listener to the invoice
  public void addChangeListener(ChangeListener listener) {
    listeners.addChangeListener(listener);
  }

  // Return an iterator for the items.
  public Iterator<Item> getItems() {
    return new Iterator<Item>() {
      public boolean hasNext() {
        return current < items.size();
      }

      public Item next() {
        return items.get(current++);
      }

      public void remove() {
        throw new UnsupportedOperationException();
      }

      private int current = 0;
    };
  }

  public String format(InvoiceFormatter formatter) {
    String s = formatter.formatHeader();
    Iterator<Item> iter = getItems();
    while (iter.hasNext())
      s += formatter.formatItem(iter.next());
    return s + formatter.formatFooter();
  }

  private ListenerList listeners = new ListenerList();
  private ArrayList<Item> items;
}