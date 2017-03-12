package discountstrategy;

/**
 *
 * @author cscherbert1
 */
public class NoDiscount implements DiscountStrategy{
    
    private double percentOff;
    
    public NoDiscount(){
        setDiscount();
    }

    @Override
    public double getDiscount() {
        return percentOff;
    }

    private void setDiscount() {
        percentOff = 0.00;
    }
    
    
    
    
    
    
    
}
