package module;

public class WrongLogin extends RuntimeException {
    public WrongLogin(String message) {
        super(message);
    }
}
