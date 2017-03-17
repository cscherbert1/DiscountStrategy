package discountstrategy;

/**
 *
 * @author cscherbert1
 */
public class PosTerminal {
    private Receipt receipt;
    private OutputStrategy guiOutput;
    private OutputStrategy consoleOutput;
    private int transactionNumber;
    private ReceiptFormatter formatter;
    
    public PosTerminal(OutputStrategy guiOutput, OutputStrategy consoleOutput, ReceiptFormatter formatter){
        setGuiOutput(guiOutput);
        setConsoleOutput(consoleOutput);
        transactionNumber = 0;
        //this should have a setter. Validation: formatter can't be null
        this.formatter = formatter;
        
        
    }

    public final void startSale(String custID, DataAccessStrategy db) {
        //custID CAN be null. It gets converted to empty string in Customer constructor. 
        if(db == null){
            throw new IllegalArgumentException("Must provide a Data Access Strategy");
        } else {
            transactionNumber++;            
            //pass custID and db to Receipt where they are used
            receipt = new Receipt(custID, db, transactionNumber, formatter);

        }

    }

    public final void addItemToSale(String prodID, int qty, DataAccessStrategy db) {
        if(prodID == null || db == null){
            throw new IllegalArgumentException("No values can be null. (prodID & DataAccessStrategy");
        } else if(qty <= 0 || qty >10000){
            throw new IllegalArgumentException("Quantity must be greater than 0 and less than 10000");
        } else {
            //ask receipt to pass the prodID and qty to the LineItem where it is used
            receipt.addLineItem(prodID, qty, db); 
        }

    }

    public final void endSale() {
        //output the receipt
        guiOutput.generateReceipt(receipt.getReceiptData(transactionNumber, formatter));
        consoleOutput.generateReceipt(receipt.getReceiptData(transactionNumber, formatter));
    }

    public final OutputStrategy getGuiOutput() {
        return guiOutput;
    }

    public final void setGuiOutput(OutputStrategy guiOutput) {
        if(guiOutput == null){
            throw new IllegalArgumentException("Output is mandatory");
        } else {
           this.guiOutput = guiOutput;           
        }

    }

    public final OutputStrategy getConsoleOutput() {
        return consoleOutput;
    }

    public final void setConsoleOutput(OutputStrategy consoleOutput) {
        if(consoleOutput == null){
            throw new IllegalArgumentException("Output is mandatory");
        } else {
                   this.consoleOutput = consoleOutput; 
        }

    }   
      
}
