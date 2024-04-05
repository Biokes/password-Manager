package africa.semoicolon.exceptions;

public class InvalidDetailsException extends PasswordSaverException{

    public InvalidDetailsException(){
        super("No  match for the details provided\nPls check And retry");
    }
}
