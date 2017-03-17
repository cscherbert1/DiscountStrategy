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
        if (prodID == null) {
            throw new IllegalArgumentException("Product ID cannot be null");
        } else if (db == null){
            throw new IllegalArgumentException("DataAccessStrategy cannot be null");
        } else {
            return db.findProduct(prodID, db);            
        }

    }
    
    public final String getLineData(){
        String data = "";
        data += product.getProdID() + "   ";
        data += product.getProdName() + "   ";
        data += product.getPrice() + "   ";
        data += getQty() + "   "; 
        data += getSubtotal() + "   ";
        data += product.getDiscountStrategy().getDiscount(qty, product.getPrice());
        
        return data;
    }
    
    public final double getSubtotal(){
        double subtotal = (product.getPrice() * getQty());
        return subtotal;
    }
    
    public double getTotalSaved(){
        double totalSaved = 0.00;
        totalSaved = product.getDiscountStrategy().getDiscount(qty, product.getPrice());
        return totalSaved;
    }

    public final int getQty() {
        return qty;
    }

    public final void setQty(int qty) {
        if (qty < 1 || qty > 10000){
            throw new IllegalArgumentException("Quantity must be betweeen 1 and 10,000");
        } else {
            this.qty = qty;   
        }
    }
}
