package discountstrategy;

/**
 *
 * @author cscherbert1
 */
public class Product {
    private String prodID;
    private String prodName;
//    private String prodDetails;
    private double price;
    private DiscountStrategy ds;
    
    public Product(String prodID, String prodName, double price, DiscountStrategy ds){
        setProdID(prodID);
        setProdName(prodName);
        setPrice(price); 
        setDiscountStrategy(ds);  
    }
    
    public final double getDiscount(int qty) {
        return ds.getDiscount(qty, price);
    }

    public final String getProdID() {
        return prodID;
    }

    public final void setProdID(String prodID) {
        //need validation
        this.prodID = prodID;
    }

    public final String getProdName() {
        return prodName;
    }

    public final void setProdName(String prodName) {
        //need validation
        this.prodName = prodName;
    }

    public final double getPrice() {
        return price;
    }

    public final void setPrice(double price) {
        //need validation
        this.price = price;
    }

    public final DiscountStrategy getDiscountStrategy() {
        return ds;
    }
    
    public final void setDiscountStrategy(DiscountStrategy ds){
        //need validation
        this.ds = ds;
    }

   
}
