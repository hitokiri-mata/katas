package clean.code.kata.list.exercise;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ListUtilTest {

    @Test
    public void testLinkedListAdd() {

	List<Integer> firstList = Arrays.asList(1, 2, 3);
	List<Integer> secondList = Arrays.asList(3, 4);
	List<Integer> expectedList = Arrays.asList(1, 5, 7);
	assertEquals(expectedList, ListUtils.toCombine(firstList, secondList));

    }

}
