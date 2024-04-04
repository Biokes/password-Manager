package africa.semicolon.servicesTest;

import africa.semoicolon.dtos.requests.LoginDetailsRequest;
import africa.semoicolon.dtos.requests.PasswordDetailsRequest;
import africa.semoicolon.dtos.requests.RegisterRequest;
import africa.semoicolon.dtos.requests.SavePasswordRequest;
import africa.semoicolon.exceptions.InvalidFieldException;
import africa.semoicolon.exceptions.UsernameExistsException;
import africa.semoicolon.services.PasswordManagerServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
@SpringBootTest
public class UserServiceTest{
    @Autowired
    private PasswordManagerServices passwordManagerServices;
    @Test
    public void RegisterUser_testUserISRegistered(){
        RegisterRequest request = new RegisterRequest();
        request.setFirstname("ade");
        request.setLastname("adey");
        request.setUsername("username1");
        request.setMasterPassword("password101");
        passwordManagerServices.register(request);
        assertEquals(1, passwordManagerServices.countUsers());
    }
    @Test
    void registerWithInvalidDetails_testExceptionIsThrown(){
        RegisterRequest request = new RegisterRequest();
        request.setFirstname("ade");
        request.setLastname("adey");
        request.setUsername("");
        request.setMasterPassword("password101");
        assertThrows(InvalidFieldException.class,()-> passwordManagerServices.register(request));
    }
    @Test
    void createUserWithExistingUsername_testExceptonIsThrown(){
        RegisterRequest request = new RegisterRequest();
        request.setFirstname("ade");
        request.setLastname("adey");
        request.setUsername("username1");
        request.setMasterPassword("password101");
        passwordManagerServices.register(request);
        assertThrows(UsernameExistsException.class,()->passwordManagerServices.register(request));
    }
    @Test
    void loginToViewPassword_testUserIsLooggedIn(){
        RegisterRequest request = new RegisterRequest();
        request.setFirstname("ade");
        request.setLastname("adey");
        request.setUsername("username1");
        request.setMasterPassword("password101");
        passwordManagerServices.register(request);
        assertEquals(1, passwordManagerServices.countUsers());
        PasswordDetailsRequest passwordDetailsRequest = new PasswordDetailsRequest();
        passwordDetailsRequest.setUsername("username1");
        passwordDetailsRequest.setPassword("password101");
        assertEquals(0, passwordManagerServices.countLoginDetailsOfUser(passwordDetailsRequest));
    }
    @Test
    void savePassword_testPasswordIsSaved(){
        RegisterRequest request = new RegisterRequest();
        request.setFirstname("ade");
        request.setLastname("adey");
        request.setUsername("username1");
        request.setMasterPassword("password101");
        passwordManagerServices.register(request);
        SavePasswordRequest savePasswordRequest = new SavePasswordRequest();
        savePasswordRequest.setUserName("username1");
        savePasswordRequest.setWebsiteName("my website");
        savePasswordRequest.setWebsiteUsername("username1");
        savePasswordRequest.setWebsitePassword("password");
        passwordManagerServices.saveLoginDetails(savePasswordRequest);
        LoginDetailsRequest loginDetails = new LoginDetailsRequest();
        loginDetails.setUsername("username1");
        loginDetails.setPassword("password101");
        assertEquals(1, passwordManagerServices.countUserLoginDetails(loginDetails));
    }
    @Test
    void viewWebsiteDetails_testWebsiteDetailsIsGotten(){}
    @Test
    void updateWebsiteDetails_testWebsiteDetailsIsUpdated(){}
    @Test
    void addToWebsiteDetails_testWebsiteDetailsIsAddedTo(){}
    @Test
    void deleteWebsiteDetails_testWebsiteDetailsIsDeleted(){}
    @Test
    void deleteUser_testUserIsDeleted(){}
    @Test
    void deleteUserWithWrongDetails_testExceptionIsThrown(){}
    @Test
    void updateWebsiteDetailsWithWrongDetails_testExceptionIsThrown(){}
    @Test
    void addToWrongWebsiteDetails_testExceptionIsThrown(){}
}