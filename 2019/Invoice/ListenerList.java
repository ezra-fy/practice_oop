
import java.util.ArrayList;
import javax.swing.event.ChangeListener;

/**
 *  A list of ChangeListener objects
 */

public class ListenerList {

  public ArrayList<ChangeListener> getListeners() {
    return listeners;
  }

  public void setListeners(ArrayList<ChangeListener> listeners) {
    this.listeners = listeners;
  }

  // Add a change listener to the invoice
  public void addChangeListener(ChangeListener listener) {
    listeners.add(listener);
  }

  private ArrayList<ChangeListener> listeners;
}