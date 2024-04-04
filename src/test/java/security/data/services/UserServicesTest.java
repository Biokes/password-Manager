package security.data.services;

import africa.semoicolon.dtos.RegisterRequest;
import africa.semoicolon.services.SecurityUserService;
import africa.semoicolon.services.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServicesTest{
    @Autowired
    private SecurityUserService userService;
    @Test
    public void saveLoginDetails_testLogInDetailsIsSaved(){
        RegisterRequest request = new RegisterRequest();
        userService.register(request);
    }
}
