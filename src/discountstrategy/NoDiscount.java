package discountstrategy;

/**
 *
 * @author cscherbert1
 */
public class NoDiscount implements DiscountStrategy{
    private final double NO_DISCOUNT = 0.00;
    
    @Override
    public double getDiscount(int qty, double price) {
          return NO_DISCOUNT;
    }       
}
