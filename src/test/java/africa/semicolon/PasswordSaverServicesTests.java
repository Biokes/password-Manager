package africa.semicolon;

import africa.semoicolon.dtos.requests.RegisterRequest;
import africa.semoicolon.exceptions.InvalidFieldException;
import africa.semoicolon.services.PasswordManagerServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class PasswordSaverServicesTests{
    @Test
    void createUser_testUserIsCreated(){
        RegisterRequest request = new RegisterRequest();
        request.setFirstname("abbey");
        request.setLastname("lastname");
        request.setUsername("uesrNAme");
        request.setMasterPassword("password");
        passwordManagerServices.register(request);
        assertEquals(1, passwordManagerServices.countUsers());
    }
    @Test
    void RegisterWithInvalidDetais_testExceptionIsThrown(){
        RegisterRequest request = new RegisterRequest();
        request.setFirstname("abbey");
        request.setLastname("lastname");
        request.setUsername("uesrNAme");
        request.setMasterPassword("password");
        assertThrows(InvalidFieldException.class,()->passwordManagerServices.register(request));
    }
    @Autowired
    private PasswordManagerServices passwordManagerServices;
}
