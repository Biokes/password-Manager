package africa.semoicolon.services;

import africa.semoicolon.data.models.WebsiteDetails;
import africa.semoicolon.data.repositories.LoginDetailsBank;
import africa.semoicolon.dtos.reponses.LoginDetailsResponse;
import africa.semoicolon.dtos.requests.SavePasswordRequest;
import africa.semoicolon.dtos.requests.ViewLoginDetailsRequest;
import africa.semoicolon.utils.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PasswordSaverLoginDetailsService implements LoginDetailsService{
    public void save(SavePasswordRequest savePasswordRequest){
        WebsiteDetails details = Mapper.mapSavePasswordRequest(savePasswordRequest);
        loginDetailsBank.save(details);
    }
    public LoginDetailsResponse fetchDetails(ViewLoginDetailsRequest viewLoginDetails){
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
    public List<WebsiteDetails> findByUsername(String username){
        return loginDetailsBank.findByUsername(username);
    }
    private LoginDetailsBank loginDetailsBank;
}
