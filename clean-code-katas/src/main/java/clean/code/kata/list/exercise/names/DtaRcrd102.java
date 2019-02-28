package clean.code.kata.list.exercise.names;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

class DtaRcrd102 {

    private static final int COMMISSIONED = 0;
    private static final int HOURLY = 1;
    private int id;
    private String n;
    private String lst_n;
    private Date genymdhms;
    private Date modymdhms;
    private int type;
    private double pay;
    private double cmsion;

    public Date getGenymdhms() {
	return genymdhms;
    }

    public void setGenymdhms(Date genymdhms) {
	this.genymdhms = genymdhms;
    }

    public Date getModymdhms() {
	return modymdhms;
    }

    public void setModymdhms(Date modymdhms) {
	this.modymdhms = modymdhms;
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
    public Money calculatePay(DtaRcrd102 e) throws InvalidEmployeeType {
	switch (e.type) {
	case COMMISSIONED:
	    return calculateCommissioned(e);
	case HOURLY:
	    return calculateHourlyPay(e);
	default:
	    throw new InvalidEmployeeType(e.type);
	}
    }

    private Money calculateHourlyPay(DtaRcrd102 e) {
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
	long diffInMillies = Math.abs(e.getModymdhms().getTime() - e.getGenymdhms().getTime());
	long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
	//if is different to 40 then calculate pay
	if (diff > 40) {
	    long extraHours = diff - 40;
	    pay = (40 * e.getPay()) + (extraHours * e.getPay());
	} else
	    pay = diff * e.getPay();

	return new Money(pay);
    }

    private Money calculateCommissioned(DtaRcrd102 e) {
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
}