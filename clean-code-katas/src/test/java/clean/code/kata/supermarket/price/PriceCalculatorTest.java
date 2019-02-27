package clean.code.kata.supermarket.price;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PriceCalculatorTest {

    @Test
    public void calculateUnitPrice() throws NotDiscountStrategyFoundException {
	Product product = new Product();
	product.setPrice(0.65);
	Double expectedPrice = new Double(0.65);
	Integer quantity = 1;
	DiscountType discountType = DiscountType.NONE;
	PriceCalculator priceCalculator = new PriceCalculator();
	UnitDiscountStrategy unitDiscountStrategy = new UnitDiscountStrategy();
	unitDiscountStrategy.setDiscountType(discountType);
	priceCalculator.registreDiscountStrategy(unitDiscountStrategy);
	Double price = priceCalculator.calculate(product, quantity, discountType);
	System.out.println("price : " + price);
	assertEquals(expectedPrice, price);

    }

    @Test
    public void calculateWholesaleDiscount() throws NotDiscountStrategyFoundException {
	Product product = new Product();
	product.setPrice(0.65);
	Integer quantity = 3;
	Integer discountQuantity = 3;
	Double expectedPrice = new Double(1);
	PriceCalculator priceCalculator = new PriceCalculator();
	CloseGroupDiscountStrategy closeGroupDiscountStrategy = new CloseGroupDiscountStrategy();
	closeGroupDiscountStrategy.setDiscountQuantity(discountQuantity);
	closeGroupDiscountStrategy.setGroupPrice(1);
	closeGroupDiscountStrategy.setDiscountType(DiscountType.CLOSE_GROUP);
	priceCalculator.registreDiscountStrategy(closeGroupDiscountStrategy);
	Double price = priceCalculator.calculate(product, quantity, closeGroupDiscountStrategy.getDiscountType());
	assertEquals(expectedPrice, price);

    }
    
    @Test
    public void calculateWholesaleDiscountWithItemPrice() throws NotDiscountStrategyFoundException {
	Product product = new Product();
	product.setPrice(0.65);
	Integer quantity = 4;
	Integer discountQuantity = 3;
	Double expectedPrice = new Double(1.65);
	PriceCalculator priceCalculator = new PriceCalculator();
	CloseGroupDiscountStrategy closeGroupDiscountStrategy = new CloseGroupDiscountStrategy();
	closeGroupDiscountStrategy.setDiscountQuantity(discountQuantity);
	closeGroupDiscountStrategy.setGroupPrice(1);
	closeGroupDiscountStrategy.setDiscountType(DiscountType.CLOSE_GROUP);
	priceCalculator.registreDiscountStrategy(closeGroupDiscountStrategy);
	Double price = priceCalculator.calculate(product, quantity, closeGroupDiscountStrategy.getDiscountType());
	assertEquals(expectedPrice, price);
    }

}
