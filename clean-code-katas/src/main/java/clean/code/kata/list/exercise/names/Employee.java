package clean.code.kata.list.exercise.names;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

class Employee {

    private static final int COMMISSIONED = 0;
    private static final int HOURLY = 1;
    private static final int WEEK_HOURS = 1;

    private int id;
    private String n;
    private String lst_n;
    private Date inputDate;
    private Date outputDate;
    private int type;
    private double pay;
    private double cmsion;

    public Date getInputDate() {
	return inputDate;
    }

    public void setInputDate(Date inputDate) {
	this.inputDate = inputDate;
    }

    public Date getOutputDate() {
	return outputDate;
    }

    public void setOutputDate(Date outputDate) {
	this.outputDate = outputDate;
    }

    public int getType() {
	return type;
    }

    public void setType(int type) {
	this.type = type;
    }

    public double getPay() {
	return pay;
    }

    public void setPay(double pay) {
	this.pay = pay;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getN() {
	return n;
    }

    public void setN(String n) {
	this.n = n;
    }

    public String getLst_n() {
	return lst_n;
    }

    public void setLst_n(String lst_n) {
	this.lst_n = lst_n;
    }

    public double getCmsion() {
	return cmsion;
    }

    public void setCmsion(double cmsion) {
	this.cmsion = cmsion;
    }

    /**
     * this method calculate the payment
     * 
     * @param e
     * @return
     * @throws InvalidEmployeeType
     */
    public Money calculatePay(Employee e) throws InvalidEmployeeType {
	switch (e.type) {
	case COMMISSIONED:
	//    return calculateCommissioned(e);
	case HOURLY:
	    return calculateHourlyPay(e);
	default:
	    throw new InvalidEmployeeType(e.type);
	}
    }

    private Money calculateHourlyPay(Employee employee) {
	long differenceInMillieSeconds = Math
		.abs(employee.getOutputDate().getTime() - employee.getInputDate().getTime());
	long workingHours = TimeUnit.HOURS.convert(differenceInMillieSeconds, TimeUnit.MILLISECONDS);
	pay = workingHours * employee.getPay();
	if (workingHours > WEEK_HOURS) {
	    long extraHours = workingHours - WEEK_HOURS;
	    pay = (WEEK_HOURS * employee.getPay()) + (extraHours * employee.getPay());
	}
	return new Money(pay);
    }
/*
    private Money calculateCommissioned(Employee e) {
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
	long diffInMillies = Math.abs(e.getModymdhms().getTime() - e.getGenymdhms().getTime());
	long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

	if (diff > 40) {
	    long extraHours = diff - 40;
	    pay = (40 * e.getPay()) + (extraHours * e.getPay());
	} else
	    pay = diff * e.getPay();

	return new Money(pay * 30 * e.getCmsion());
    }
    */
}