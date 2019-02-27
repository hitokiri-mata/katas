package clean.code.kata.supermarket.price;

public class Product {
    private Measure measure;
    private Double price;

    public Double getPrice() {
	return price;
    }

    public void setPrice(double price) {
	this.price = price;
    }

    public Measure getMeasure() {
	return measure;
    }

    public void setMeasure(Measure measure) {
	this.measure = measure;
    }

}
