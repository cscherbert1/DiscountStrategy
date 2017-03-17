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
        this.custID = custID;
    }

    public final String getCustName() {
        //check to see if custName is null, if yes, return empty string. (paid w/ cash)
        return custName;

    }

    public final void setCustName(String custName) {
        //custName is allowed to be null in this instance. What other validation should be considered?
        this.custName = custName;
    }
    
    
}
