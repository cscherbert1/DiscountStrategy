package discountstrategy;

/**
 *
 * @author cscherbert1
 */
public class PosTerminal {
    private Receipt receipt;
    private OutputStrategy guiOutput;
    private OutputStrategy consoleOutput;
    
    public PosTerminal(OutputStrategy guiOutput, OutputStrategy consoleOutput){
        setGuiOutput(guiOutput);
        setGuiOutput(consoleOutput);
        
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
        guiOutput.generateReceipt(receipt.getReceiptData());
        //consoleOutput.generateReceipt(receipt.getReceiptData());
    }

    public OutputStrategy getGuiOutput() {
        return guiOutput;
    }

    public void setGuiOutput(OutputStrategy guiOutput) {
        //validation
        if(guiOutput == null){
            System.out.println("Failure at PosTerminal.setOutput. output strategy cannot be null");
            //throw new NullPointerException();
        } else {
           this.guiOutput = guiOutput;           
        }

    }
    
    
    
    
}
