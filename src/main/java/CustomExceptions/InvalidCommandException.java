package CustomExceptions;

public class InvalidCommandException extends Exception {
    public InvalidCommandException(Exception ex) {
        super("Invalid Command Given", ex);
    }
}
