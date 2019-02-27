package clean.code.kata.supermarket.price;

public class NotDiscountStrategyFoundException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public NotDiscountStrategyFoundException(String message) {
	super(message);
    }

}
