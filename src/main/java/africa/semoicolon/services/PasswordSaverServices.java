package africa.semoicolon.services;

import africa.semoicolon.data.models.WebsiteDetails;
import africa.semoicolon.dtos.requests.*;
import africa.semoicolon.services.PasswordManagerServices;
import africa.semoicolon.services.PasswordSaverUserService;
import africa.semoicolon.utils.Mapper;
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
    public void saveDetails(ViewLoginDetailsRequest viewLoginDetails){
        loginDetailsService.fetchDetails(viewLoginDetails);
    }

    private PasswordSaverUserService passwordSaverUserService;
    private LoginDetailsService loginDetailsService;
}
