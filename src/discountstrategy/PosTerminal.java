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
        setConsoleOutput(consoleOutput);
        
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
        consoleOutput.generateReceipt(receipt.getReceiptData());
    }

    public final OutputStrategy getGuiOutput() {
        return guiOutput;
    }

    public final void setGuiOutput(OutputStrategy guiOutput) {
        if(guiOutput == null){
            throw new NullPointerException();
        } else {
           this.guiOutput = guiOutput;           
        }

    }

    public final OutputStrategy getConsoleOutput() {
        return consoleOutput;
    }

    public final void setConsoleOutput(OutputStrategy consoleOutput) {
        if(consoleOutput == null){
            throw new NullPointerException();
        } else {
                   this.consoleOutput = consoleOutput; 
        }

    }
    
    
    
    
}
