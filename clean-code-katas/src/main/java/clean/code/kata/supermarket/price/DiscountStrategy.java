package clean.code.kata.supermarket.price;

public interface DiscountStrategy {

    public Double calculate(Product product, Integer quantity);

    public void setDiscountType(DiscountType discountType);

    public DiscountType getDiscountType();

}
