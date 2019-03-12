package clean.code.kata.meaningful.names;

import junit.framework.Assert;

public class ComparisonCompactor {
    private int context;
    private String firstString;
    private String secondString;
    private int prefixIndex;
    private int suffix;

    public ComparisonCompactor(int context, String firstString, String secondString) {
	this.context = context;
	this.firstString = firstString;
	this.secondString = secondString;
    }

    public String compact(String message) {
	if (firstString == null || secondString == null || firstString.equals(secondString))
	    return Assert.format(message, firstString, secondString);

	prefixIndex = 0;
	for (; prefixIndex < Math.min(firstString.length(), secondString.length()); prefixIndex++) {
	    if (firstString.charAt(prefixIndex) != secondString.charAt(prefixIndex))
		break;
	}
	int firstStringSuffixIndex = firstString.length() - 1;
	int secondStringSuffixIndex = secondString.length() - 1;
	for (; secondStringSuffixIndex >= prefixIndex && suffix >= prefixIndex; secondStringSuffixIndex--, firstStringSuffixIndex--) {
	    if (firstString.charAt(firstStringSuffixIndex) != secondString.charAt(secondStringSuffixIndex))
		break;
	}
	suffix = firstString.length() - firstStringSuffixIndex;
	String cmp1 = compactString(firstString);
	String cmp2 = compactString(secondString);

	return Assert.format(message, cmp1, cmp2);

    }

    private String compactString(String s) {
	String result = "(" + s.substring(prefixIndex, s.length() - suffix + 1) + ")";
	if (prefixIndex > 0)
	    result = (prefixIndex > context ? "..." : "") + firstString.substring(Math.max(0, prefixIndex - context), prefixIndex) + result;
	if (suffix > 0) {
	    int end = Math.min(firstString.length() - suffix + 1 + context, firstString.length());
	    result = result + (firstString.substring(firstString.length() - suffix + 1, end)
		    + (firstString.length() - suffix + 1 < firstString.length() - context ? "..." : ""));
	}
	return result;
    }

}
