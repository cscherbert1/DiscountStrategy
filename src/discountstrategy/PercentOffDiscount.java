package discountstrategy;

/**
 *
 * @author cscherbert1
 */
public class PercentOffDiscount implements DiscountStrategy {

    private double percentOff;

    public PercentOffDiscount(double percentOff) {
        setPercentOff(percentOff);
    }

    @Override
    public double getDiscount(int qty, double price) {
        if (qty < 0 || qty >= 10000) {
            throw new IllegalArgumentException("Quantity must be greater than 0 and less than 10,000");
        } else if (price < 0 || price > 1000000) {
            throw new IllegalArgumentException("Price cannot be 0 and must be less than 1,000,000");
        } else {
            double discount = 0.00;
            discount = (qty * price * percentOff);
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
}
