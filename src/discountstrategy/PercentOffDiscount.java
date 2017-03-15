package discountstrategy;

/**
 *
 * @author cscherbert1
 */
public class PercentOffDiscount implements DiscountStrategy {
    private double percentOff;
    
    
    public PercentOffDiscount(double percentOff){
        setPercentOff(percentOff);
    }

    @Override
    public double getDiscount(int qty, double price) {
        double discount = 0.00;
        discount = (qty * price * percentOff);
        return discount;
    }

    public final void setPercentOff(double percentOff) {
        //need validation
        
        this.percentOff = percentOff;
    }


    
}
