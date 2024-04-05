package africa.semoicolon.services;

import africa.semoicolon.data.models.User;
import africa.semoicolon.data.models.WebsiteDetails;
import africa.semoicolon.dtos.reponses.LoginDetailsResponse;
import africa.semoicolon.dtos.requests.*;
import africa.semoicolon.exceptions.InvalidDetailsException;
import africa.semoicolon.exceptions.InvalidLoginDetailsException;
import africa.semoicolon.exceptions.UserDoesNotExistException;
import africa.semoicolon.exceptions.UsernameExistsException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static africa.semoicolon.utils.Validator.*;

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
//    public long countLoginDetailsOfUser(PasswordDetailsRequest passwordDetailsRequest){
//        return 0;
//    }
    public long countUserLoginDetails(LoginDetailsRequest loginDetails){
        validateUserLoginDetails(loginDetails);
      return loginDetailsService.findByUsername(loginDetails.getUsername()).size();
    }
    public void saveLoginDetails(SavePasswordRequest savePasswordRequest){
        validateSavePasswordRequest(savePasswordRequest);
        loginDetailsService.save(savePasswordRequest);
    }
    public LoginDetailsResponse fetchDetails(ViewLoginDetailsRequest viewLoginDetails){
        validateViewLoginDetails(viewLoginDetails);
        return loginDetailsService.fetchDetails(viewLoginDetails);
    }
    public void wipeAll(){
        loginDetailsService.deleteAll();
        passwordSaverUserService.deleteAll();
    }
    public void updateLoginDetails(UpdateDetailsRequest update){
        validateUpdateRequest(update);
        LoginDetailsRequest request = extractLoginDetails(update);
        validateUserLoginDetails(request);
        loginDetailsService.updateLoginDetailsPassword(update);
    }
    public void deletePasswordDetails(DeleteWebsiteDetailsRequest deleteRequest){
        validateDeleteWebsiteRequest(deleteRequest);
        LoginDetailsRequest loginDetails = new LoginDetailsRequest();
        loginDetails.setUsername(deleteRequest.getUsername());
        loginDetails.setPassword(deleteRequest.getPassword());
        validateUserLoginDetails(loginDetails);
        loginDetailsService.deleteWebsiteDetails(deleteRequest);
    }
    @Override
    public void deleteUser(LoginDetailsRequest loginRequest){
        validateLoginDetailsRequest(loginRequest);
        if( passwordSaverUserService.userExist(loginRequest.getUsername())){
            User user = passwordSaverUserService.findUser(loginRequest.getUsername( ));
            if(user.getPassword().equalsIgnoreCase(loginRequest.getPassword())){
                passwordSaverUserService.deleteUser(user);
                List<WebsiteDetails> detailsList = loginDetailsService.findByUsername(loginRequest.getUsername());
                loginDetailsService.deleteAll(detailsList);
                return;
            }
            throw new InvalidDetailsException();
        }
        throw new UserDoesNotExistException();
    }
    private LoginDetailsRequest extractLoginDetails(UpdateDetailsRequest update){
        validateUpdateRequest(update);
        LoginDetailsRequest request = new LoginDetailsRequest();
        request.setUsername(update.getUsername());
        request.setPassword(update.getPassword());
        return request;
    }
    private void validateUserLoginDetails(LoginDetailsRequest request){
        validateLoginDetailsRequest(request);
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
