package discountstrategy;

/**
 *
 * @author cscherbert1
 */
public interface DataAccessStrategy {
    
    public abstract Customer findCustomer(String custID, DataAccessStrategy db);
    
    public abstract Product findProduct(String prodID, DataAccessStrategy db);
    

    
}
