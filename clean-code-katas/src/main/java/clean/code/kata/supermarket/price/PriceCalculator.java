package clean.code.kata.supermarket.price;

import java.util.HashMap;
import java.util.Map;

public class PriceCalculator {

    public Map<DiscountType, DiscountStrategy> discountStrategies = new HashMap<>();

    /**
     * 
     * @param product
     * @param quantity
     * @param discountType
     * @return
     * @throws NotDiscountStrategyFoundException
     */
    public Double calculate(Product product, Integer quantity, DiscountType discountType)
	    throws NotDiscountStrategyFoundException {
	return this.getDiscountStregy(discountType).calculate(product, quantity);
    }

    /**
     * 
     * @param discountType
     * @return
     * @throws NotDiscountStrategyFoundException
     */
    public DiscountStrategy getDiscountStregy(DiscountType discountType) throws NotDiscountStrategyFoundException {
	DiscountStrategy discountStrategy = discountStrategies.get(discountType);
	if (discountStrategy == null) {
	    throw new NotDiscountStrategyFoundException(
		    "The discount strategy was not registered '" + discountType + "'");
	}
	return discountStrategy;
    }

    public void registreDiscountStrategy(DiscountStrategy discountStrategy) {
	discountStrategies.put(discountStrategy.getDiscountType(), discountStrategy);
    }

}
