
package discountstrategy;

/**
 *
 * @author cscherbert1
 */
public class Startup {

    public static void main(String[] args) {
        DataAccessStrategy db = new MemoryDataAccess();
//        Store khols = new Store();
        OutputStrategy guiOutput = new GuiReceiptOutput();
        OutputStrategy consoleOutput = new ConsoleReceiptOutput();
        
//        khols.setStoreName("Khols");
        
        PosTerminal pos = new PosTerminal(guiOutput, consoleOutput);
        //start sale: pass in customer ID if available
        pos.startSale("", db);
        //add product1 (ProdID and qty)
        pos.addItemToSale("A101", 3, db);
        //add product2
        pos.addItemToSale("B205", 2, db);     
        //end sale    
        pos.endSale();
        //output receipt
        
       

    }
    
}
