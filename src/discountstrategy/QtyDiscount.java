package discountstrategy;

/**
 *
 * @author cscherbert1
 */
public class QtyDiscount implements DiscountStrategy{
    
    private double percentOff;
    private int qtyNeeded;
        
    public QtyDiscount(double percentOff, int qtyNeeded){
        setPercentOff(percentOff);
        setQtyNeeded(qtyNeeded);
    }

    @Override
    public double getDiscount(int qty, double price) {
        double discount = 0;
        
        if(qty >= qtyNeeded) {
            discount = price * qty * percentOff;
        } else {
            discount = 0;
        }
        return discount;
    }
    
    public void setPercentOff(double percentOff){
        //need validation
        this.percentOff = percentOff;
    }

    public int getQtyNeeded() {
        return qtyNeeded;
    }

    public void setQtyNeeded(int qtyNeeded) {
        //need validation
        this.qtyNeeded = qtyNeeded;
    }
    
    
    
}
