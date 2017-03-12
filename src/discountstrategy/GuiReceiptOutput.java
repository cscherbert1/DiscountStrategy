package discountstrategy;

import javax.swing.JOptionPane;

/**
 *
 * @author cscherbert1
 */
public class GuiReceiptOutput implements OutputStrategy{

    @Override
    public void generateReceipt(String receiptData) {
        JOptionPane.showMessageDialog(null, receiptData);
    }
    
}
