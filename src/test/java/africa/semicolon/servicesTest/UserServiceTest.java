package africa.semicolon.servicesTest;

import africa.semoicolon.Main;
import africa.semoicolon.dtos.reponses.LoginDetailsResponse;
import africa.semoicolon.dtos.requests.*;
import africa.semoicolon.exceptions.InvalidFieldException;
import africa.semoicolon.exceptions.UsernameExistsException;
import africa.semoicolon.services.PasswordManagerServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
@SpringBootTest(classes=Main.class)
public class UserServiceTest{
    @Autowired
    private PasswordManagerServices passwordManagerServices;

    @BeforeEach
    void wipe(){
        passwordManagerServices.wipeAll( );
    }

    @Test
    public void RegisterUser_testUserISRegistered(){
        RegisterRequest request=new RegisterRequest( );
        request.setFirstname("ade");
        request.setLastname("adey");
        request.setUsername("username1");
        request.setMasterPassword("password101");
        passwordManagerServices.register(request);
        assertEquals(1, passwordManagerServices.countUsers( ));
    }

    @Test
    void registerWithInvalidDetails_testExceptionIsThrown(){
        RegisterRequest request=new RegisterRequest( );
        request.setFirstname("ade");
        request.setLastname("adey");
        request.setUsername("");
        request.setMasterPassword("password101");
        assertThrows(InvalidFieldException.class, ()->passwordManagerServices.register(request));
    }

    @Test
    void createUserWithExistingUsername_testExceptonIsThrown(){
        RegisterRequest request=new RegisterRequest( );
        request.setFirstname("ade");
        request.setLastname("adey");
        request.setUsername("username1");
        request.setMasterPassword("password101");
        passwordManagerServices.register(request);
        assertThrows(UsernameExistsException.class, ()->passwordManagerServices.register(request));
    }

    @Test
    void loginToViewPassword_testUserIsLooggedIn(){
        RegisterRequest request=new RegisterRequest( );
        request.setFirstname("ade");
        request.setLastname("adey");
        request.setUsername("username1");
        request.setMasterPassword("password101");
        passwordManagerServices.register(request);
        assertEquals(1, passwordManagerServices.countUsers( ));
        PasswordDetailsRequest passwordDetailsRequest=new PasswordDetailsRequest( );
        passwordDetailsRequest.setUsername("username1");
        passwordDetailsRequest.setPassword("password101");
        assertEquals(0, passwordManagerServices.countLoginDetailsOfUser(passwordDetailsRequest));
    }

    @Test
    void savePassword_testPasswordIsSaved(){
        RegisterRequest request=new RegisterRequest( );
        request.setFirstname("ade");
        request.setLastname("ade");
        request.setUsername("username1");
        request.setMasterPassword("password101");
        passwordManagerServices.register(request);
        assertEquals(1, passwordManagerServices.countUsers( ));
        SavePasswordRequest savePasswordRequest=new SavePasswordRequest( );
        savePasswordRequest.setUserName("username1");
        savePasswordRequest.setWebsiteName("my website");
        savePasswordRequest.setWebsiteUsername("username1");
        savePasswordRequest.setWebsitePassword("password");
        passwordManagerServices.saveLoginDetails(savePasswordRequest);
        LoginDetailsRequest loginDetails=new LoginDetailsRequest( );
        loginDetails.setUsername("username1");
        loginDetails.setPassword("password101");
        assertEquals(1, passwordManagerServices.countUserLoginDetails(loginDetails));
    }

    @Test
    void viewWebsiteDetails_testWebsiteDetailsIsGotten(){
        RegisterRequest request=new RegisterRequest( );
        request.setFirstname("ade");
        request.setLastname("adey");
        request.setUsername("username1");
        request.setMasterPassword("password101");
        passwordManagerServices.register(request);
        SavePasswordRequest savePasswordRequest=new SavePasswordRequest( );
        savePasswordRequest.setUserName("username1");
        savePasswordRequest.setWebsiteName("myWebsite");
        savePasswordRequest.setWebsiteUsername("websiteUserName");
        savePasswordRequest.setWebsitePassword("password");
        passwordManagerServices.saveLoginDetails(savePasswordRequest);
        LoginDetailsRequest loginDetails=new LoginDetailsRequest( );
        loginDetails.setUsername("username1");
        loginDetails.setPassword("password101");
        assertEquals(1, passwordManagerServices.countUserLoginDetails(loginDetails));
        ViewLoginDetailsRequest viewLoginDetails=new ViewLoginDetailsRequest( );
        viewLoginDetails.setWebsiteName("myWebsite");
        viewLoginDetails.setUsername("username1");
        viewLoginDetails.setMasterPassword("password101");
        LoginDetailsResponse viewResponse=passwordManagerServices.fetchDetails(viewLoginDetails);
        assertEquals("myWebsite", viewResponse.getWebsiteName( ));
        assertEquals("password", viewResponse.getWebsitePasssword( ));
        assertEquals("websiteUserName", viewResponse.getWebsiteUsername( ));
    }

    @Test
    void updateWebsiteDetails_testWebsiteDetailsIsUpdated(){
        RegisterRequest request=new RegisterRequest( );
        request.setFirstname("ade");
        request.setLastname("adey");
        request.setUsername("username1");
        request.setMasterPassword("password101");
        passwordManagerServices.register(request);
        SavePasswordRequest savePasswordRequest=new SavePasswordRequest( );
        savePasswordRequest.setUserName("username1");
        savePasswordRequest.setWebsiteName("myWebsite");
        savePasswordRequest.setWebsiteUsername("websiteUserName");
        savePasswordRequest.setWebsitePassword("password");
        passwordManagerServices.saveLoginDetails(savePasswordRequest);
        UpdateDetailsRequest update=new UpdateDetailsRequest( );
        update.setUsername("username1");
        update.setPassword("password101");
        update.setWebsiteName("myWebsite");
        update.setWebsitePassword("");
        assertThrows(InvalidFieldException.class, ()->passwordManagerServices.updateLoginDetails(update));
        update.setWebsitePassword("password");
        passwordManagerServices.updateLoginDetails(update);
        ViewLoginDetailsRequest viewLoginDetails=new ViewLoginDetailsRequest( );
        viewLoginDetails.setWebsiteName("myWebsite");
        viewLoginDetails.setUsername("username1");
        viewLoginDetails.setMasterPassword("password101");
        LoginDetailsResponse viewResponse=passwordManagerServices.fetchDetails(viewLoginDetails);
        assertEquals("myWebsite", viewResponse.getWebsiteName( ));
        assertEquals("password", viewResponse.getWebsitePasssword( ));
        assertEquals("websiteUserName", viewResponse.getWebsiteUsername( ));
    }

    @Test
    void deleteWebsiteDetails_testWebsiteDetailsIsDeleted(){
        RegisterRequest request=new RegisterRequest( );
        request.setFirstname("ade");
        request.setLastname("adey");
        request.setUsername("username1");
        request.setMasterPassword("password101");
        passwordManagerServices.register(request);
        SavePasswordRequest savePasswordRequest=new SavePasswordRequest( );
        savePasswordRequest.setUserName("username1");
        savePasswordRequest.setWebsiteName("myWebsite");
        savePasswordRequest.setWebsiteUsername("websiteUserName");
        savePasswordRequest.setWebsitePassword("password");
        passwordManagerServices.saveLoginDetails(savePasswordRequest);
        DeleteWebsiteDetailsRequest deleteRequest=new DeleteWebsiteDetailsRequest( );
        deleteRequest.setUsername("username1");
        deleteRequest.setPassword("password101");
        deleteRequest.setWebsiteUsername("websiteUserName");
        passwordManagerServices.deletePasswordDetails(deleteRequest);
    }

    @Test void deleteUser_testUserIsDeleted(){
    }

    @Test void deleteUserWithWrongDetails_testExceptionIsThrown(){
    }

    @Test void updateWebsiteDetailsWithWrongDetails_testExceptionIsThrown(){
    }

    @Test void addToWrongWebsiteDetails_testExceptionIsThrown(){
    }
    @Test void deleteWebsiteDetailsWithWrongDetails_testExceptionIsThrown(){}
}