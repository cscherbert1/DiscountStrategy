package discountstrategy;

/**
 *
 * @author cscherbert1
 */
public interface DiscountStrategy {

    public abstract double getDiscount(int qty, double price);    
    
}
