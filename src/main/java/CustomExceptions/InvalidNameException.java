package CustomExceptions;

public class InvalidNameException extends Exception {
    public InvalidNameException(Exception ex) {
        super("Invalid name, not found in the catalog.", ex);
    }
}
