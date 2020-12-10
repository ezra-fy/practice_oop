import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * App to create simple invoices.
 */

public class InvoiceApplication {
  
  public static void main(String[] args) {
    final Invoice invoice = new Invoice();
    final InvoiceFormatter formatter = new SimpleFormatter();

    // Text area to contain the formatted invoice
    final JTextArea textArea = new JTextArea(20, 40);

    // When the invoice changes, update the text area
    ChangeListener listener = new ChangeListener() {
      public void stateChanged(ChangeEvent event) {
        textArea.setText(invoice.format(formatter));
      }
    };
    invoice.addChangeListener(listener);

    // Add items to a combo box
    final JComboBox<Item> combo = new JComboBox<Item>();
    Product hammer = new Product("Hammer", 15.95);
    Product nails = new Product("Nails", 9.95);
    Product saw = new Product("Saw", 22.45);
    combo.addItem(hammer);
    combo.addItem(nails);
    combo.addItem(saw);
    Bundle bundle = new Bundle();
    bundle.add(hammer);
    bundle.add(nails);
    combo.addItem(new DiscountedItem(bundle, 10));

    // Make a button for adding the currently selected item to the invoice
    JButton addButton = new JButton("Add");
    addButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        Item item = (Item) combo.getSelectedItem();
        invoice.addItem(item);
      }
    });

    // Put the combo box and the add button into a panel
    JPanel panel = new JPanel();
    panel.add(combo);
    panel.add(addButton);

    // Add the text area and panel to the frame
    JFrame frame = new JFrame();
    frame.add(new JScrollPane(textArea), BorderLayout.CENTER);
    frame.add(panel, BorderLayout.SOUTH);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
}