package discountstrategy;

/**
 *
 * @author cscherbert1
 */
public class NoDiscount implements DiscountStrategy{
    private final double NO_DISCOUNT = 0.00;
    
    @Override
    public final double getDiscount(int qty, double price) {
        //values passed in are not used. This method will always return 0. No validation needed.
          return NO_DISCOUNT;
    }       
}
