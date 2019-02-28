package clean.code.kata.list.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ListUtils {
    /**
     * 
     * @param firstList
     * @param secondList
     * @return
     */
    public static List<Integer> toCombine(List<Integer> firstList, List<Integer> secondList) {
	if (firstList == null) {
	    throw new IllegalArgumentException("the fisrt list can't be null");
	}
	if (secondList == null) {
	    throw new IllegalArgumentException("the second list can't be null");
	}
	Integer[] resultVector = new Integer[firstList.size()];
	Stack<Integer> firstStack = new Stack<>();
	Stack<Integer> secondStack = new Stack<>();
	// adding the java List to stack data structure.
	firstStack.addAll(firstList);
	secondStack.addAll(secondList);
	// Iterate the first stack plus and add the result, to result vector in it
	// natural order
	while (!firstStack.isEmpty()) {
	    resultVector[firstStack.size() - 1] = firstStack.pop() + (secondStack.isEmpty() ? 0 : secondStack.pop());
	}
	return Arrays.asList(resultVector);

    }

}
