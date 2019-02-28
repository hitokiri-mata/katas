package clean.code.kata.list.exercise.names;

public class InvalidEmployeeType extends Exception {

   

    public InvalidEmployeeType(int type) {
	super("ivalid employee type '" + type + "'");
    }

}
