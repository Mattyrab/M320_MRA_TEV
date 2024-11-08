package main;

public class InvalidInputException extends Throwable {
    public InvalidInputException(String message){
        super(message);
    }
}
