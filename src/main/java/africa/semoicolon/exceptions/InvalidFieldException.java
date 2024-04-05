package africa.semoicolon.exceptions;

public class InvalidFieldException extends PasswordSaverException{
    public InvalidFieldException(){
        super("Input fields cannot be empty");
    }
}
