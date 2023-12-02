package main.java.exceptions;

public class InvalidInputException extends Exception{
    public String toString() {
        return "Invalid command type is provided";
    }
}
