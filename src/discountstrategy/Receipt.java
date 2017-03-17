package discountstrategy;

/**
 *
 * @author cscherbert1
 */
public class Receipt {

    private DataAccessStrategy db;
    private Customer customer;
    private LineItem[] lineItems;
    private int transactionNumber;

    public Receipt(String custID, DataAccessStrategy db, int transactionNumber, ReceiptFormatter formatter) {
        if(transactionNumber <0) {
            throw new IllegalArgumentException("Transaction number must be greater than 0");
        } else if (db == null){
            throw new IllegalArgumentException("This program must have access to a database");
        } else if(custID == null || custID.isEmpty()){
            customer = new Customer ("", "");
        } else {
            //use db and custID to find the appropriate customer if it exists
            customer = findCustomer(custID, db); 
        }
        //initialize the lineItems array
        lineItems = new LineItem[0];
        this.transactionNumber = transactionNumber;
    }
    
    

    private final Customer findCustomer(String custID, DataAccessStrategy db) {
        if (db == null){
            throw new IllegalArgumentException("DataAccessStrategy cannot be null");
        } else {
            //this method does the work of finding the customer
            return db.findCustomer(custID, db);
        }

    }

    public final void addLineItem(String prodID, int qty, DataAccessStrategy db) {
        if (prodID == null || db == null){
            throw new IllegalArgumentException("Null is not an accepted value (prodID & DataAccessStrategy");
        } else {
            //generates new line item based on prodID, qty. Uses the db to find the correct item based on prodID
            LineItem item = new LineItem(prodID, qty, db);
            //add created line item into the array
            addToArray(item);
        }

    }
    
    private final void addToArray(LineItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot complete action addToArray if item is null");
        } else {
                    
            LineItem[] tempItems = new LineItem[(lineItems.length +1)];
            System.arraycopy(lineItems, 0, tempItems, 0, lineItems.length);
            tempItems[lineItems.length] = item;
            lineItems = tempItems;
            tempItems = null; 
        }
  
    }

    public final String getReceiptData(int transactionNumber, ReceiptFormatter formatter) {
        if (transactionNumber < 0) {
            throw new IllegalArgumentException("Transaction Number cannot be less than 0");
        } else {
            return formatter.getFormattedData(this);
//            String data = "";
//    //        data += store.getReceiptGreeting() + "\n\n";
//            data += "Sold to: " + customer.getCustName() + "\n";
//            data += "Receipt Number: " + transactionNumber + "\n\n";
//
//            data += getColumnHeadings();
//
//            for (LineItem item : lineItems) {
//                data += item.getLineData() + "\n";
//            }
//            data += "\n";
//            data += "Net Total: " + getNetTotal() + "\n";
//            data += "Total Saved: " + getTotalSaved() + "\n";
//            data += "Total Due: " + getTotalDue() + "\n";
//
//            return data;
        }
    }
    
    public final String getColumnHeadings(){
        String columnHeading = "";
        columnHeading += "ID   Item   Price   Qty   Subtotal   Discount\n";
        columnHeading += "---------------------------------------------------\n";
        return columnHeading;
    }
    
    public final double getNetTotal(){
        double netTotal = 0.00;
        //loop through line items array
        for (LineItem item : lineItems){
            netTotal += item.getSubtotal(); 
        }
        
        return netTotal;
    }
    
    public final double getTotalSaved(){
        double totalSaved = 0.00;
        for (LineItem item : lineItems){
            totalSaved += item.getTotalSaved();
        }
        
        return totalSaved;
    }
    
    public final double getTotalDue(){
        double totalDue = (getNetTotal() - getTotalSaved());
        return totalDue;
        
    }

    public DataAccessStrategy getDb() {
        return db;
    }

    public void setDb(DataAccessStrategy db) {
        this.db = db;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LineItem[] getLineItems() {
        return lineItems;
    }

    public void setLineItems(LineItem[] lineItems) {
        this.lineItems = lineItems;
    }

    public int getTransactionNumber() {
        return transactionNumber;
    }

}
