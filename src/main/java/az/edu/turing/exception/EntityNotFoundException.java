package az.edu.turing.exception;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String message){
        System.out.println(message);
    }
}
