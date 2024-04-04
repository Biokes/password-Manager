package africa.semoicolon.utils;

import africa.semoicolon.data.models.User;
import africa.semoicolon.dtos.requests.RegisterRequest;
import africa.semoicolon.exceptions.InvalidFieldException;

public class Mapper{
    public static User mapRegisterRequest(RegisterRequest request){
        User user = new User();
        validateRegisterRequest(request);
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setUsername(request.getUsername());
        user.setPassword(request.getMasterPassword());
        return user;
    }
    public static void validate(String userName){
        if(userName.isEmpty())
            throw new InvalidFieldException();
    }
    public static void validateRegisterRequest(RegisterRequest request){
        validate(request.getFirstname());
        validate(request.getLastname());
        validate(request.getUsername());
        validate(request.getMasterPassword());
    }
}
