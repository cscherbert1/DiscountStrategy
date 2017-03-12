package discountstrategy;

/**
 *
 * @author cscherbert1
 */
public class PosTerminal {
    private Receipt receipt;
    private OutputStrategy output;
    private OutputStrategy output2;
    
    public PosTerminal(OutputStrategy output, OutputStrategy output2){
        setOutput(output);
        setOutput(output2);
        
    }

    public final void startSale(String custID, DataAccessStrategy db) {
        //pass custID and db to Receipt where they are used
        receipt = new Receipt(custID, db);
    }

    public final void addItemToSale(String prodID, int qty, DataAccessStrategy db) {
        //ask receipt to pass the prodID and qty to the LineItem where it is used
        receipt.addLineItem(prodID, qty, db);
    }

    public final void endSale() {
        //output the receipt
        output.generateReceipt(receipt.getReceiptData());
        output2.generateReceipt(receipt.getReceiptData());
    }

    public OutputStrategy getOutput() {
        return output;
    }

    public void setOutput(OutputStrategy output) {
        //validation
        if(output == null){
            throw new NullPointerException();
        } else {
           this.output = output;           
        }

    }
    
    
    
    
}
