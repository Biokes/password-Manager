package africa.semoicolon.services;

import africa.semoicolon.data.models.WebsiteDetails;
import africa.semoicolon.data.repositories.LoginDetailsBank;
import africa.semoicolon.dtos.reponses.LoginDetailsResponse;
import africa.semoicolon.dtos.requests.DeleteWebsiteDetailsRequest;
import africa.semoicolon.dtos.requests.SavePasswordRequest;
import africa.semoicolon.dtos.requests.UpdateDetailsRequest;
import africa.semoicolon.dtos.requests.ViewLoginDetailsRequest;
import africa.semoicolon.exceptions.InvalidDetailsException;
import africa.semoicolon.utils.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static africa.semoicolon.utils.Validator.*;

@Service
@AllArgsConstructor
public class PasswordSaverLoginDetailsService implements LoginDetailsService{
    public void save(SavePasswordRequest savePasswordRequest){
        validateSavePasswordRequest(savePasswordRequest);
        WebsiteDetails details = Mapper.mapSavePasswordRequest(savePasswordRequest);
        loginDetailsBank.save(details);
    }
    public LoginDetailsResponse fetchDetails(ViewLoginDetailsRequest viewLoginDetails){
        validateViewLoginDetails(viewLoginDetails);
        List<WebsiteDetails> listDetails = loginDetailsBank.findByUsername(viewLoginDetails.getUsername());
        for(WebsiteDetails details : listDetails){
            if(details.getWebsiteName().equalsIgnoreCase(viewLoginDetails.getWebsiteName()))
                return Mapper.mapLoginDetailsResponseWith(details);
        }
        throw new InvalidDetailsException();
    }
    public void deleteAll(){
        loginDetailsBank.deleteAll();
    }
    public void deleteAll(List<WebsiteDetails> listOfDetails){
        loginDetailsBank.deleteAll(listOfDetails);
    }
    public List<WebsiteDetails> findByUsername(String username){
        return loginDetailsBank.findByUsername(username);
    }
    public void updateLoginDetailsPassword(UpdateDetailsRequest update){
       List<WebsiteDetails> listDetails =  findByUsername(update.getUsername());
        for(WebsiteDetails details : listDetails){
            if( details.getWebsiteName().equalsIgnoreCase(update.getWebsiteName()))
                details.setWebsitePassword(update.getWebsitePassword());
            return;
        }
        throw new InvalidDetailsException();
    }
    public void deleteWebsiteDetails(DeleteWebsiteDetailsRequest deleteRequest){
        List<WebsiteDetails> listDetails = loginDetailsBank.findByUsername(deleteRequest.getUsername());
        for(WebsiteDetails details : listDetails){
            if(details.getWebsiteName().equalsIgnoreCase(deleteRequest.getWebsiteName())){
                loginDetailsBank.deleteByWebsiteName(deleteRequest.getWebsiteName( ));
                return;
            }
        }
        throw new InvalidDetailsException();

    }

    private LoginDetailsBank loginDetailsBank;
}
