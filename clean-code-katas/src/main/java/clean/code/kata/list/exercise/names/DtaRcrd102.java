package clean.code.kata.list.exercise.names;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DtaRcrd102 {

    private Date genymdhms;
    private Date modymdhms;
    private final String pszqint = "102";
    private int tpe;
    private double pay;
    private double cmsion;

    public Money calculatePay(DtaRcrd102 e) throws InvalidEmployeeType {
	switch (e.tpe) {
	case 0:
	    return calculateCommissioned();
	case 1:
	    return calculateHourlyPay();
	}
    }
    
    private Money calculateHourlyPay() {
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
	long diffInMillies = Math.abs(modymdhms.getTime() - modymdhms.getTime());
	long diff = TimeUnit.HOURS.convert(diffInMillies, TimeUnit.MILLISECONDS);

	if (diff > 40) {
	    long extraHours = diff - 40;
	    pay = (40 * pay) + (extraHours * pay);
	} else
	    pay = diff * pay;

	return new Money(pay * 30);
    }

    private Money calculateCommissioned() {
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
	long diffInMillies = Math.abs(modymdhms.getTime() - modymdhms.getTime());
	long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

	if (diff > 40) {
	    long extraHours = diff - 40;
	    pay = (40 * pay) + (extraHours * pay);
	} else
	    pay = diff * pay;

	return new Money(pay * 30 * cmsion);
    }

}
