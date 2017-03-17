package discountstrategy;

/**
 *
 * @author cscherbert1
 */
public class DetailedReceiptFormat implements ReceiptFormatter {
    @Override
    public final String getFormattedData(Receipt receipt) {

            String data = "";
    //        data += store.getReceiptGreeting() + "\n\n";
            data += "Sold to: " + receipt.getCustomer().getCustName() + "\n";
            data += "Receipt Number: " + receipt.getTransactionNumber() + "\n\n";

            data += receipt.getColumnHeadings();

            for (LineItem item : receipt.getLineItems()) {
                data += item.getLineData() + "\n";
            }
            data += "\n";
            data += "Net Total: " + receipt.getNetTotal() + "\n";
            data += "Total Saved: " + receipt.getTotalSaved() + "\n";
            data += "Total Due: " + receipt.getTotalDue() + "\n";

            return data;
    }
}
