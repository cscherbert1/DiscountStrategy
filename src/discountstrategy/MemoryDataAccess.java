package discountstrategy;

/**
 *
 * @author cscherbert1
 */
public class MemoryDataAccess implements DataAccessStrategy {

    private Customer[] customers = {
        new Customer("100", "John Smith"),
        new Customer("200", "Sally Jones"),
        new Customer("300", "Bob Clementi")
    };

    private Product[] products = {
        new Product("A101", "MLB Brewer's Hat ", 19.95, new PercentOffDiscount(0.15)),
        new Product("B205", "Men's Dress Shirt", 35.50, new QtyDiscount(0.15, 5)),
        new Product("C222", "Women's Socks    ", 9.50, new NoDiscount())
    };

    /**
     * Tries to find a Customer by customer id.
     *
     * @param custID
     * @param db
     * @return found Customer or null if not found or bad argument
     */
    @Override
    public final Customer findCustomer(String custID, DataAccessStrategy db) {
        // validation is needed for method parameter
        if (custID == null || custID.length() == 0) {
            throw new IllegalArgumentException("Sorry, MemoryDataAccess.findCustomer method has "
                    + "illegal argument");
            //return null;  // end method prematurely after log to console
        } else {

            Customer customer = null;
            for (Customer c : customers) {
                if (custID.equals(c.getCustID())) {
                    customer = c;
                    break;
                }
            }
            return customer;
        }
    }

    @Override
    public final Product findProduct(String prodID, DataAccessStrategy db) {
        // validation is needed for method parameter
        if (prodID == null || prodID.length() == 0) {
            throw new IllegalArgumentException("Sorry, MemoryDataAccess.findProduct method has "
                    + "illegal argument");
            //return null;  // end method prematurely after log to console
        } else {
            Product product = null;
            for (Product p : products) {
                if (prodID.equals(p.getProdID())) {
                    product = p;
                    break;
                }
            }
            return product;
        }
    }
}
