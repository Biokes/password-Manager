package africa.semoicolon.services;

import africa.semoicolon.data.models.User;
import africa.semoicolon.data.models.WebsiteDetails;
import africa.semoicolon.dtos.reponses.LoginDetailsResponse;
import africa.semoicolon.dtos.reponses.ViewAllResponse;
import africa.semoicolon.dtos.requests.*;
import africa.semoicolon.exceptions.*;
import africa.semoicolon.utils.Validator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static africa.semoicolon.utils.Validator.*;

@Service
@AllArgsConstructor
public class PasswordSaverServices implements PasswordManagerServices{
    public void register(RegisterRequest request){
        validateRegisterRequest(request);
        for(User user : passwordSaverUserService.findAll()){
            if(user.getUsername().equalsIgnoreCase(request.getUsername( )))
                throw new UsernameExistsException(request.getUsername() + " already exist");
        }
        passwordSaverUserService.registerUser(request);
    }
    public long countUsers(){
        return passwordSaverUserService.count();
    }
    public long countUserLoginDetails(LoginDetailsRequest loginDetails){
        validateUserLoginDetails(loginDetails);
      return loginDetailsService.findByUsername(loginDetails.getUsername()).size();
    }
    public void saveLoginDetails(SavePasswordRequest savePasswordRequest){
        validateSavePasswordRequest(savePasswordRequest);
        validateUserExistence(savePasswordRequest.getUserName());
        List<WebsiteDetails> details = loginDetailsService.findByUsername(savePasswordRequest.getUserName( ));
        for(WebsiteDetails websites : details){
            if(websites.getWebsiteName().equalsIgnoreCase(savePasswordRequest.getWebsiteName( ))){
                throw new WebsiteAlreadyExistException();
            }
        }
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
    public ViewAllResponse viewAllDetails(ViewAllRequest request){
        Validator.validateRequest(request);
        Optional<User> userGotten =Optional.ofNullable(passwordSaverUserService.findUser(request.getUsername( )));
        if( userGotten.isPresent() && userGotten.get().getPassword().equalsIgnoreCase(request.getPassword()))
            return loginDetailsService.getAllUserDetails(request.getUsername());
        throw new InvalidDetailsException();
    }
    private LoginDetailsRequest extractLoginDetails(UpdateDetailsRequest update){
        validateUpdateRequest(update);
        LoginDetailsRequest request = new LoginDetailsRequest();
        request.setUsername(update.getUsername());
        request.setPassword(update.getPassword());
        return request;
    }
    private void validateUserExistence(String userName){
        Optional<User> user =Optional.ofNullable(passwordSaverUserService.findUser(userName));
        if(user.isEmpty())
            throw new UserDoesNotExistException();
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
