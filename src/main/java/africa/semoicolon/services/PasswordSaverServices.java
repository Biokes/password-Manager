package africa.semoicolon.services;

import africa.semoicolon.data.models.User;
import africa.semoicolon.dtos.reponses.LoginDetailsResponse;
import africa.semoicolon.dtos.requests.*;
import africa.semoicolon.exceptions.InvalidLoginDetailsException;
import africa.semoicolon.exceptions.UsernameExistsException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PasswordSaverServices implements PasswordManagerServices{
    public void register(RegisterRequest request){
        for(User user : passwordSaverUserService.findAll()){
            if(user.getUsername().equalsIgnoreCase(request.getUsername( )))
                throw new UsernameExistsException(request.getUsername() + " already exist");
        }
        passwordSaverUserService.registerUser(request);
    }
    public long countUsers(){
        return passwordSaverUserService.count();
    }
    public long countLoginDetailsOfUser(PasswordDetailsRequest passwordDetailsRequest){
        return 0;
    }
    public long countUserLoginDetails(LoginDetailsRequest loginDetails){
        validateUserLoginDetails(loginDetails);
      return loginDetailsService.findByUsername(loginDetails.getUsername()).size();
    }
    public void saveLoginDetails(SavePasswordRequest savePasswordRequest){
        loginDetailsService.save(savePasswordRequest);
    }
    public LoginDetailsResponse fetchDetails(ViewLoginDetailsRequest viewLoginDetails){
        return loginDetailsService.fetchDetails(viewLoginDetails);
    }
    public void wipeAll(){
        loginDetailsService.deleteAll();
        passwordSaverUserService.deleteAll();
    }
    private void validateUserLoginDetails(LoginDetailsRequest request){
        for(User user : passwordSaverUserService.findAll()){
            if(user.getUsername().equalsIgnoreCase(request.getUsername()) &&
            user.getPassword().equalsIgnoreCase(request.getPassword()))
                return ;
        }
        throw new InvalidLoginDetailsException();
    }

    private PasswordSaverUserService passwordSaverUserService;
    private LoginDetailsService loginDetailsService;
}
