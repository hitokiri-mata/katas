package clean.code.kata.supermarket.price;

public class CloseGroupDiscountStrategy implements DiscountStrategy {

    private DiscountType discountType;
    private Integer discountQuantity;
    private Integer groupPrice;

    /*
     * (non-Javadoc)
     * 
     * @see
     * clean.code.kata.supermarket.price.DiscountStrategy#calculate(clean.code.kata.
     * supermarket.price.Product, java.lang.Integer)
     */
    public Double calculate(Product product, Integer quantity) {
	Integer discountGroups = quantity / discountQuantity;
	Integer unitWithOutDiscount = quantity % discountQuantity;
	return (discountGroups * groupPrice) + unitWithOutDiscount * product.getPrice();
    }

    @Override
    public void setDiscountType(DiscountType discountType) {
	this.discountType = discountType;
    }

    @Override
    public DiscountType getDiscountType() {
	return this.discountType;
    }

    public Integer getDiscountQuantity() {
	return discountQuantity;
    }

    public void setDiscountQuantity(Integer discountQuantity) {
	this.discountQuantity = discountQuantity;
    }

    public Integer getGroupPrice() {
	return groupPrice;
    }

    public void setGroupPrice(Integer groupPrice) {
	this.groupPrice = groupPrice;
    }
}
