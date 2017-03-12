package discountstrategy;

/**
 *
 * @author cscherbert1
 */
public interface DiscountStrategy {

    public abstract double getDiscount();

//    public abstract void setDiscount();
    
    /*
    I thought that setDiscount should be abstract as well, showing any future programmers who implement this code that both are needed. 
    However, because there is variation between each setDsicount (straight percentage, percentage and qty, none, etc) having a 
    setDiscount method inside the interface causes errors. What am I missing?
    
    */
    
    
}
