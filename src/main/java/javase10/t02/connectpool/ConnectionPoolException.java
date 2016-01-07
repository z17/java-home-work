package javase10.t02.connectpool;

public class ConnectionPoolException extends Exception {
    private static final  long serialVersionUID =1L;

    public ConnectionPoolException(String message, Exception e) {
        super(message, e);
    }
}
