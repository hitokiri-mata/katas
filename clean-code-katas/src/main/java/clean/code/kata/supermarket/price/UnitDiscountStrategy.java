package clean.code.kata.supermarket.price;

public class UnitDiscountStrategy implements DiscountStrategy {

    private DiscountType discountType;
    private Double discount;

    /*
     * (non-Javadoc)
     * 
     * @see
     * clean.code.kata.supermarket.price.DiscountStrategy#calculate(clean.code.kata.
     * supermarket.price.Product, java.lang.Integer)
     */
    public Double calculate(Product product, Integer quantity) {
	Double price = product.getPrice();
	if (hasADiscount()) {
	    price = (product.getPrice() * discount) / 100;
	}
	return price * quantity;
    }

    private boolean hasADiscount() {
	return discount != null && discount > 0;
    }

    @Override
    public void setDiscountType(DiscountType discountType) {
	this.discountType = discountType;
    }

    @Override
    public DiscountType getDiscountType() {
	return this.discountType;
    }

}
