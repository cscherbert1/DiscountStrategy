package discountstrategy;

/**
 *
 * @author cscherbert1
 */
public class PercentOffDiscount implements DiscountStrategy {
    private double percentOff;
    
    
    public PercentOffDiscount(double percentOff){
        setDiscount(percentOff);
    }

    @Override
    public double getDiscount() {
        return percentOff;
    }

    public void setDiscount(double percentOff) {
        //need validation
        
        this.percentOff = percentOff;
    }


    
}
