package discountstrategy;

/**
 *
 * @author cscherbert1
 */
public class ConsoleReceiptOutput implements OutputStrategy {

    @Override
    public final void generateReceipt(String receiptData) {
        System.out.println(receiptData);
    }
    
}
