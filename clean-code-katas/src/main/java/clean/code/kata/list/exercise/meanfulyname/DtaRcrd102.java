package clean.code.kata.list.exercise.meanfulyname;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import clean.code.kata.list.exercise.names.InvalidEmployeeType;
import clean.code.kata.list.exercise.names.Money;

public class Employee {
    public static final int COMMISIONED_EMPLOYEE = 0;
    public static final int TEMPORAL_EMPLOYEE = 1;
    public static final int WORK_HOURS_WEEK = 40;
    public static final int DAYS_OF_MOUNTH = 30;

    private Date inDate;
    private Date outDate;
    private final String pszqint = "102";
    private int type;
    private double pay;
    private double regularHourCost;
    private double extraHourCost;
    private double cmsion;

    public Money calculatePay(Employee employee) throws InvalidEmployeeType {
	switch (employee.type) {
	case COMMISIONED_EMPLOYEE:
	    return calculateCommissioned();
	case TEMPORAL_EMPLOYEE:
	    return calculateHourlyPay();
	default:
	    return null;
	}
    }

    private Money calculateHourlyPay() {
	long differenceInMilliSeconds = Math.abs(outDate.getTime() - inDate.getTime());
	long workingHours = TimeUnit.HOURS.convert(differenceInMilliSeconds, TimeUnit.MILLISECONDS);
	
	pay = workingHours * regularHourCost;

	if (workingHours > WORK_HOURS_WEEK) {
	    long extraHours = workingHours - WORK_HOURS_WEEK;
	    pay = (workingHours * regularHourCost) + (extraHours * extraHourCost);
	}

	return new Money(pay * DAYS_OF_MOUNTH);
    }

    private Money calculateCommissioned() {
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
	long diffInMillies = Math.abs(outDate.getTime() - inDate.getTime());
	long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

	if (diff > 40) {
	    long extraHours = diff - 40;
	    pay = (40 * pay) + (extraHours * pay);
	} else
	    pay = diff * pay;

	return new Money(pay * 30 * cmsion);
    }

}
