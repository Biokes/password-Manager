package data;

import africa.semoicolon.dtos.RegisterRequest;
import africa.semoicolon.services.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class UserServicesTest{
    @Test
    public void saveLoginDetails_testLogInDetailsIsSaved(){
        RegisterRequest request = new RegisterRequest();
        userService.register(request);
    }
    @Autowired
    private UserService userService;

}
