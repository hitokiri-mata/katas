package clean.code.kata.meaninful.names;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import clean.code.kata.meaningful.names.ComparisonCompactor;

public class ComparisonCompactorTest{

    @Test
    public void testMessage() {
	String failure = new ComparisonCompactor(0, "b", "c").compact("a");
	assertTrue("expected:<[b]> but was:<[c]>".equals(failure));
    }

    @Test
    public void testStarSame() {
	String failure = new ComparisonCompactor(1, "ba", "bc").compact(null);
	assertTrue("expected:<b[a]> but was:<b[c]>".equals(failure));
    }

    @Test
    public void testEndSame() {
	String failure = new ComparisonCompactor(1, "ab", "cb").compact(null);
	assertTrue("expected:<[a]b> but was:<[c]b>".equals(failure));
    }

    @Test
    public void testSame() {
	String failure = new ComparisonCompactor(1, "ab", "ab").compact(null);
	assertTrue("expected:<[ab]> but was:<[ab]>".equals(failure));
    }

    @Test
    public void testNoContextStarAndEndSame() {
	String failure = new ComparisonCompactor(0, "abc", "adc").compact(null);
	assertTrue("expected:<...[b]...> but was:<...[d]...>".equals(failure));
    }
    
    @Test
    public void tesStarAndContext() {
	String failure = new ComparisonCompactor(1, "abc", "adc").compact(null);
	assertTrue("expected:<a[b]c> but was:<a[d]c...>".equals(failure));
    }
    
    @Test
    public void tesStarAndEndContextWithEllipses() {
	String failure = new ComparisonCompactor(1, "abcde", "abfde").compact(null);
	assertTrue("expected:<...b[c]d...> but was:<...b[f]d...>".equals(failure));
    }
    
    @Test
    public void testComparisonErrorStarSameComplete() {
	String failure = new ComparisonCompactor(2, "ab", "abc").compact(null);
	assertTrue("expected:<...ab[]...> but was:<...ab[c]...>".equals(failure));
    }
}
