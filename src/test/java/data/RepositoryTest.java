package data;

import africa.semoicolon.data.Models.LoginDetails;
import africa.semoicolon.dtos.RegisterRequest;
import africa.semoicolon.services.PasswordServices;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class RepositoryTest{
    @Test void saveLoginDetails_testLogInDetailsIsSaved(){
        RegisterRequest request = new RegisterRequest();
        passwordServices.save(request);
    }
    @Autowired
    private PasswordServices passwordServices;

}
