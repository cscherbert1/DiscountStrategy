
package discountstrategy;

/**
 *
 * @author cscherbert1
 */
public class Startup {

    public static void main(String[] args) {
        DataAccessStrategy db = new MemoryDataAccess();
        OutputStrategy guiOutput = new GuiReceiptOutput();
        OutputStrategy consoleOutput = new ConsoleReceiptOutput();
        ReceiptFormatter formatter = new DetailedReceiptFormat();
                
        PosTerminal pos = new PosTerminal(guiOutput, consoleOutput, formatter);
        //start sale: pass in customer ID if available
        pos.startSale("300", db);
        //add product1 (ProdID and qty)
        pos.addItemToSale("A101", 3, db);
        //add product2
        pos.addItemToSale("B205", 5, db); 
        //add product 3 
        pos.addItemToSale("C222", 2, db);
        //end sale    
        pos.endSale();
        
        
        pos.startSale("", db);
        //add product1 (ProdID and qty)
        pos.addItemToSale("A101", 3, db);
        //add product2
        pos.addItemToSale("B205", 2, db); 
        //add product 3 
        pos.addItemToSale("C222", 2, db);
        //end sale    
        pos.endSale();

        
       

    }
    
}
