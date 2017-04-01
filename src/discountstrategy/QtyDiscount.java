package discountstrategy;

/**
 *
 * @author cscherbert1
 */
public class QtyDiscount implements DiscountStrategy {

    private double percentOff;
    private int qtyNeeded;

    public QtyDiscount(double percentOff, int qtyNeeded) {
        setPercentOff(percentOff);
        setQtyNeeded(qtyNeeded);
    }

    @Override
    public final double getDiscount(int qty, double price) throws IllegalArgumentException{
        if (qty < 0 || qty > 10000) {
            throw new IllegalArgumentException("Quantity must be greater than 0 and less than 10,000");
        } else if (price < 0 || price > 1000000) {
            throw new IllegalArgumentException("Price cannot be 0 and must be less than 1,000,000");
        } else {
            double discount = 0;

            if (qty >= qtyNeeded) {
                discount = price * qty * percentOff;
            } else {
                discount = 0;
            }
            return discount;
        }
    }

    public final void setPercentOff(double percentOff) {
        if (percentOff < 0 || percentOff > 1) {
            throw new IllegalArgumentException("Percent off applied for this discount must be greater than 0 and cannot be greater than 1");
        } else {
            this.percentOff = percentOff;
        }
    }

    public final int getQtyNeeded() {
        return qtyNeeded;
    }

    public final void setQtyNeeded(int qtyNeeded) {
        if (qtyNeeded <= 0) {
            throw new IllegalArgumentException("Quantity needed to make this discount valid must be greater than 0.");
        } else {
            this.qtyNeeded = qtyNeeded;
        }
    }
}
