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

    public Receipt(String custID, DataAccessStrategy db, int transactionNumber, ReceiptFormatter formatter) throws IllegalArgumentException{
        if (transactionNumber < 0) {
            throw new IllegalArgumentException("Transaction number must be greater than 0");
        } else if (db == null) {
            throw new IllegalArgumentException("To generate a receipt a Data Access Strategy must be provided.");
        } else if (custID == null || custID.isEmpty()) {
            customer = new Customer("", "");
        } else {
            //use db and custID to find the appropriate customer if it exists
            customer = findCustomer(custID, db);
        }
        //initialize the lineItems array
        lineItems = new LineItem[0];
        this.transactionNumber = transactionNumber;
    }

    private final Customer findCustomer(String custID, DataAccessStrategy db) {
        if (db == null) {
            throw new IllegalArgumentException("DataAccessStrategy cannot be null");
        } else {
            //this method does the work of finding the customer
            return db.findCustomer(custID, db);
        }
    }

    public final void addLineItem(String prodID, int qty, DataAccessStrategy db) throws IllegalArgumentException{
        if (prodID == null || db == null) {
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
            LineItem[] tempItems = new LineItem[(lineItems.length + 1)];
            System.arraycopy(lineItems, 0, tempItems, 0, lineItems.length);
            tempItems[lineItems.length] = item;
            lineItems = tempItems;
            tempItems = null;
        }
    }

    public final String getReceiptData(int transactionNumber, ReceiptFormatter formatter) {
        if (transactionNumber < 0) {
            throw new IllegalArgumentException("Transaction Number cannot be less than 0");
        } else if (formatter == null) {
            throw new IllegalArgumentException("A Receipt Formatter must be provided. formatter cannot be null.");
        } else {
            return formatter.getFormattedData(this);
        }
    }

    public final String getColumnHeadings() {
        String columnHeading = "";
        columnHeading += "ID   Item   Price   Qty   Subtotal   Discount\n";
        columnHeading += "---------------------------------------------------\n";
        return columnHeading;
    }

    public final double getNetTotal() {
        double netTotal = 0.00;
        //loop through line items array
        for (LineItem item : lineItems) {
            netTotal += item.getSubtotal();
        }

        return netTotal;
    }

    public final double getTotalSaved() {
        double totalSaved = 0.00;
        for (LineItem item : lineItems) {
            totalSaved += item.getTotalSaved();
        }

        return totalSaved;
    }

    public final double getTotalDue() {
        double totalDue = (getNetTotal() - getTotalSaved());
        return totalDue;

    }

    public final DataAccessStrategy getDb() {
        return db;
    }

    public final void setDb(DataAccessStrategy db) {
        if (db == null) {
            throw new IllegalArgumentException("Data Access Strategy must be provided. db cannot be null");
        } else {
            this.db = db;
        }

    }

    public final Customer getCustomer() {
        return customer;
    }

    public final void setCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer object must be provided. customer cannot be null.");
        } else {
            this.customer = customer;
        }

    }

    public final LineItem[] getLineItems() {
        return lineItems;
    }

    public final void setLineItems(LineItem[] lineItems) {
        if (lineItems == null) {
            throw new IllegalArgumentException("Array lineItems cannot be null. Ensure it is instantiated correctly");
        } else {
            this.lineItems = lineItems;
        }

    }

    public final int getTransactionNumber() {
        return transactionNumber;
    }

}
