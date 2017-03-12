package discountstrategy;

/**
 *
 * @author cscherbert1
 */
public class QtyDiscount implements DiscountStrategy{
    
    private double percentOff;
    private int qtyNeeded;
    private int qtyBought;
    
    /*
    How is this discount supposed to work? As far as I can tell we don't have enough inputs
    to make a proper calculation. 
    
    The MemoryDataAccess class passes in the percent and an int 5. w5 what?
    How is this supposed to interact with the 6 shirts bought using this discount in the example provided?
    
    */
    
    public QtyDiscount(double percentOff, int qtyNeeded){
        setPercentOff(percentOff);
        setQtyNeeded(qtyNeeded);
    }

    @Override
    public double getDiscount() {
        //if customer buys a certain number of items
        
        //they will get the discount
        
        //else, discount percent == 0
        return percentOff;
    }
    
    public void setPercentOff(double percentOff){
        //need validation
        this.percentOff = percentOff;
    }

    public int getQtyNeeded() {
        return qtyNeeded;
    }

    public void setQtyNeeded(int qtyNeeded) {
        this.qtyNeeded = qtyNeeded;
    }
    
    
    
}
