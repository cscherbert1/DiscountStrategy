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
        if (qty < 1 || qty > 10000){
            throw new IllegalArgumentException("Quantity must be betweeen 1 and 10,000");
        } else {
            return ds.getDiscount(qty, price);
        }   
    }

    public final String getProdID() {
        return prodID;
    }

    public final void setProdID(String prodID) {
        if(prodID == null){
            throw new IllegalArgumentException("prodID can't be null");
        }
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
