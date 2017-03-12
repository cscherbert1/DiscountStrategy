
package discountstrategy;

/**
 *
 * @author cscherbert1
 */
public class Startup {

    public static void main(String[] args) {
        DataAccessStrategy db = new MemoryDataAccess();
//        Store khols = new Store();
        OutputStrategy output = new GuiReceiptOutput();
        OutputStrategy output2 = new ConsoleReceiptOutput();
        
//        khols.setStoreName("Khols");
        
        PosTerminal pos = new PosTerminal(output, output2);
        //start sale: pass in customer ID if available
        pos.startSale("100", db);
        //add product1 (ProdID and qty)
        pos.addItemToSale("A101", 3, db);
        //add product2
        pos.addItemToSale("B205", 2, db);     
        //end sale    
        pos.endSale();
        //output receipt

    }
    
}
