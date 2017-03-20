package discountstrategy;

import javax.swing.JOptionPane;

/**
 *
 * @author cscherbert1
 */
public class GuiReceiptOutput implements OutputStrategy{

    @Override
    public final void generateReceipt(String receiptData) {
        if (receiptData == null){
            throw new IllegalArgumentException ("Receipt Data must be provided in order to generate receipt. receiptData cannot be null.");
        } else {
            JOptionPane.showMessageDialog(null, receiptData);
        }
    }
    
}
