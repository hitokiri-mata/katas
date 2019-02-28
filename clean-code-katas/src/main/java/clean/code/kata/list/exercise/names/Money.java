package clean.code.kata.list.exercise.names;

import java.util.Locale;

/**
 * Represent the money
 * @author hitokiri
 *
 */
public class Money {

    private double v;
    private Locale l;

    public Money(double pay) {
	this.v = pay;
    }

    public double getV() {
	return v;
    }

    public void setV(double v) {
	this.v = v;
    }

    public Locale getL() {
	return l;
    }

    public void setL(Locale l) {
	this.l = l;
    }

}
