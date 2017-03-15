package discountstrategy;

/**
 *
 * @author cscherbert1
 */
public class NoDiscount implements DiscountStrategy{
    
    private double percentOff;
    
    public NoDiscount(){
        setPercentOff();
    }

    @Override
    public double getDiscount(int qty, double price) {
        double discount = 0.00;
        
        return discount;
    }

    private void setPercentOff() {
        percentOff = 0.00;
    }
    
    
    
    
    
    
    
}
