package security.data.services.servicesTest;
import africa.semoicolon.dtos.RegisterRequest;
import africa.semoicolon.services.SecurityUserService;
import africa.semoicolon.services.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class SecurityUserServicesTest{
    @Autowired
    private UserService userService;
    @Test
    public void registerUser_testUserIsRegistered(){
        RegisterRequest request = new RegisterRequest();
        userService.register(request);
        assertEquals(1, userService.countAllUsers());
    }
}
