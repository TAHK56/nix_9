package ua.com.alevel.exception;

public class MyDateException extends RuntimeException {

    public MyDateException() {
    }

    @Override
    public String toString() {
        return "Incorrect date";
    }
}
