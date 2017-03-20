package discountstrategy;

/**
 *
 * @author cscherbert1
 */
public class Customer {
    private String custID;
    private String custName;
    
    public Customer(String custID, String custName){
        setCustID(custID);
        setCustName(custName);
    }

    public final String getCustID() {
        return custID;
    }

    public final void setCustID(String custID) {
        if (custID == null) {
            throw new IllegalArgumentException ("CustomrID must be provided. It cannot be null.");
        } else {
            this.custID = custID;           
        }

    }

    public final String getCustName() {
        //check to see if custName is null, if yes, return empty string. (paid w/ cash)
        return custName;

    }

    public final void setCustName(String custName) {
        //custName is allowed to be null in this instance.
        this.custName = custName;
    }
    
    
}
