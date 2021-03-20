package CustomExceptions;

public class ArgumentsException extends Exception {
    public ArgumentsException(Exception ex) {
        super("Wrong number of arguments or wrong arguments given", ex);
    }
}
