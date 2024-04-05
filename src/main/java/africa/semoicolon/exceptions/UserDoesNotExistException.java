package africa.semoicolon.exceptions;

public class UserDoesNotExistException extends PasswordSaverException{
    public UserDoesNotExistException(){
        super("User with matching details not found.");
    }
}
