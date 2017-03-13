package discountstrategy;

/**
 *
 * @author cscherbert1
 */
public class LineItem {
    //stores the product found w/ findProduct method
    private Product product;
    private int qty;

    public LineItem(String prodID, int qty, DataAccessStrategy db) {
        //constructor uses information passed in from Receipt to find the appropriate product inside the db
        product = findProduct(prodID, db);
        setQty(qty);
    }
    
    //helper method does the work of finding the product inside the db based on passed in prodID
    private final Product findProduct(String prodID, DataAccessStrategy db){
        return db.findProduct(prodID, db);
    }
    
    public String getLineData(){
        String data = "";
        data += product.getProdID() + "   ";
        data += product.getProdName() + "   ";
        data += product.getPrice() + "   ";
        data += getQty() + "   "; 
        data += getSubtotal() + "   ";
        data += getTotalDiscount();
        
        return data;
    }
    
    public double getSubtotal(){
        double subtotal = (product.getPrice() * getQty());
        return subtotal;
    }
    
    public double getTotalDiscount(){
        double totalDiscount =(product.getPrice() * (product.getDiscountStrategy().getDiscount())* getQty());
        return totalDiscount;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        //need validation
        this.qty = qty;
    }
    
    
    
}
