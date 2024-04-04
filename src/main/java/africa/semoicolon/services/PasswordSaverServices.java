package africa.semoicolon.services;

import africa.semoicolon.dtos.requests.LoginDetailsRequest;
import africa.semoicolon.dtos.requests.PasswordDetailsRequest;
import africa.semoicolon.dtos.requests.RegisterRequest;
import africa.semoicolon.dtos.requests.SavePasswordRequest;
import africa.semoicolon.services.PasswordManagerServices;
import africa.semoicolon.services.PasswordSaverUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@AllArgsConstructor
public class PasswordSaverServices implements PasswordManagerServices{
    public void register(RegisterRequest request){
        passwordSaverUserService.registerUser(request);
    }
    public long countUsers(){
        return passwordSaverUserService.count();
    }
    public long countLoginDetailsOfUser(PasswordDetailsRequest passwordDetailsRequest){
        return 0;
    }
    public long countUserLoginDetails(LoginDetailsRequest loginDetails){
        return 0;
    }
    public void saveLoginDetails(SavePasswordRequest savePasswordRequest){

    }
    private PasswordSaverUserService passwordSaverUserService;
}
