package africa.semoicolon.exceptions;

public class InvalidLoginDetailsException extends PasswordSaverException{
    public InvalidLoginDetailsException(){
        super("Invalid details provided");
    }
}
