package africa.semoicolon.utils;

import africa.semoicolon.data.Models.User;
import africa.semoicolon.dtos.RegisterRequest;

public class Mapper{
    public static User mapRegister(RegisterRequest request){
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getMasterPassword());
        return user;
    }
}
