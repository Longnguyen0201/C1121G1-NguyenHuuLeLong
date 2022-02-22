package giai_de.C10.utils;

public class NotFoundProductException extends Exception{
    public NotFoundProductException() {
    }

    public NotFoundProductException(String message) {
        super(message);
    }
}
