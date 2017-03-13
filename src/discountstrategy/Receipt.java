package discountstrategy;

/**
 *
 * @author cscherbert1
 */
public class Receipt {

    private DataAccessStrategy db;
    private Customer customer;
    private LineItem[] lineItems = new LineItem[1];

    public Receipt(String custID, DataAccessStrategy db) {
        //use db and custID to find the appropriate customer if it exists
        customer = findCustomer(custID, db);
//        //open the first spot for a line item by initializing the array
//        if (lineItems == null) {
//                lineItems = new LineItem[1];
//        }
    }

    private final Customer findCustomer(String custID, DataAccessStrategy db) {
        //this method does the work of finding the customer
        return db.findCustomer(custID, db);
    }

    public final void addLineItem(String prodID, int qty, DataAccessStrategy db) {
        //generates new line item based on prodID, qty. Uses the db to find the correct item based on prodID
        LineItem item = new LineItem(prodID, qty, db);
        //add created line item into the array
        addToArray(item);

    }

    //***************is this solution to all of the null pointer exceptions too rigid?***************
    
    private void addToArray(LineItem item) {
        //validation, can't be null
        if (item == null) {
            throw new NullPointerException();
        }
        
        /*if the commented block is run instead of the block below
        (starting w/ if(lineItems.length == 1), then a NullPointerException is thrown
        
        If the other block starting w/ if-logic is used, program runs, but only outputs to console
        despite having gui-output selected
        Also only displays the second line item, ignores the first. 
        
        I'm not sure why any of this is happening. 
        
        */ 
       
//            LineItem[] tempItems = new LineItem[(lineItems.length +1)];
//            System.arraycopy(lineItems, 0, tempItems, 0, lineItems.length);
//            tempItems[lineItems.length] = item;
//            lineItems = tempItems;
//            tempItems = null; 
        
        if (lineItems.length == 1){
            //add first line item to lineItems[0]
            lineItems[0]=item;            
        }else {          
            LineItem[] tempItems = new LineItem[(lineItems.length +1)];
            System.arraycopy(lineItems, 0, tempItems, 0, lineItems.length);
            tempItems[lineItems.length] = item;
            lineItems = tempItems;
            tempItems = null;  
        }        
    }

    public String getReceiptData() {
        String data = "";
//        data += store.getReceiptGreeting() + "\n\n";
        //need if logic if no cust name
        data += "Sold to: " + customer.getCustName() + "\n\n";

        data += getColumnHeadings();
        
        for (LineItem item : lineItems) {
            data += item.getLineData() + "\n";
        }

        return data;
    }
    
    public String getColumnHeadings(){
        String columnHeading = "";
        columnHeading += "ID   Item   Price   Qty   Subtotal   Discount\n";
        columnHeading += "---------------------------------------------------\n";
        return columnHeading;
    }

}
