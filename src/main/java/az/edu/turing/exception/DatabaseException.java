package az.edu.turing.exception;

public class DatabaseException extends RuntimeException{
    public DatabaseException(String message){
        System.out.println(message);
    }

}
