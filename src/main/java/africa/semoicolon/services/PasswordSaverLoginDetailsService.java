package africa.semoicolon.services;

import africa.semoicolon.data.models.WebsiteDetails;
import africa.semoicolon.data.repositories.LoginDetailsBank;
import africa.semoicolon.dtos.reponses.LoginDetailsResponse;
import africa.semoicolon.dtos.requests.SavePasswordRequest;
import africa.semoicolon.dtos.requests.ViewLoginDetailsRequest;
import africa.semoicolon.utils.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PasswordSaverLoginDetailsService implements LoginDetailsService{
    @Override
    public void save(SavePasswordRequest savePasswordRequest){
        WebsiteDetails details = Mapper.mapSavePasswordRequest(savePasswordRequest);
        loginDetailsBank.save(details);
    }

    @Override
    public LoginDetailsResponse fetchDetails(ViewLoginDetailsRequest viewLoginDetails){
        return null;
    }
    public void deleteAll(){
        loginDetailsBank.deleteAll();
    }

    private LoginDetailsBank loginDetailsBank;
}
