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
        
        
    }

    public String getProdID() {
        return prodID;
    }

    public void setProdID(String prodID) {
        this.prodID = prodID;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public DiscountStrategy getDiscountStrategy() {
        return ds;
    }
    
    public void setDiscountStrategy(DiscountStrategy ds){
        //need validation
        this.ds = ds;
    }

   
}
