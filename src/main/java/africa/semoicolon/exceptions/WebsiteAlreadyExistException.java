package africa.semoicolon.exceptions;

public class WebsiteAlreadyExistException extends PasswordSaverException{
    public WebsiteAlreadyExistException(){
        super("Website already exist\n update password or create with another username");
    }
}
