package discountstrategy;

/**
 *
 * @author cscherbert1
 */
public class Receipt {

    private DataAccessStrategy db;
    private Customer customer;
    private LineItem[] lineItems;

    public Receipt(String custID, DataAccessStrategy db) {
        //use db and custID to find the appropriate customer if it exists
        customer = findCustomer(custID, db);
        //initialize the lineItems array
        lineItems = new LineItem[0];

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
    
    private final void addToArray(LineItem item) {
        if (item == null) {
            throw new NullPointerException();
        }  
        
        LineItem[] tempItems = new LineItem[(lineItems.length +1)];
        System.arraycopy(lineItems, 0, tempItems, 0, lineItems.length);
        tempItems[lineItems.length] = item;
        lineItems = tempItems;
        tempItems = null; 
       
    }

    public final String getReceiptData() {
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
    
    public final String getColumnHeadings(){
        String columnHeading = "";
        columnHeading += "ID   Item   Price   Qty   Subtotal   Discount\n";
        columnHeading += "---------------------------------------------------\n";
        return columnHeading;
    }

}
