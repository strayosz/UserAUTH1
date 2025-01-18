package module;

public class WrongUser extends RuntimeException {
    public WrongUser(String message) {
        super(message);
    }
}
