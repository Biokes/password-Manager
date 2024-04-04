package africa.semoicolon.exceptions;



public class UsernameExistsException extends PasswordSaverException{
    public UsernameExistsException(){
        super("Username Already taken");
    }
}
