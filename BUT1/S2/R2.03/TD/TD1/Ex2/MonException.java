package Ex2;

public class MonException extends Exception {

    public MonException(String msg) {
        super(msg);
    }

    @Override
    public String toString() {
        return "MonException: " + getMessage();
    }

}