package africa.semoicolon.services;

import africa.semoicolon.data.models.WebsiteDetails;
import africa.semoicolon.dtos.reponses.LoginDetailsResponse;
import africa.semoicolon.dtos.requests.DeleteWebsiteDetailsRequest;
import africa.semoicolon.dtos.requests.SavePasswordRequest;
import africa.semoicolon.dtos.requests.UpdateDetailsRequest;
import africa.semoicolon.dtos.requests.ViewLoginDetailsRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoginDetailsService{
    void save(SavePasswordRequest savePasswordRequest);
    LoginDetailsResponse fetchDetails(ViewLoginDetailsRequest viewLoginDetails);
    void deleteAll();
    List<WebsiteDetails> findByUsername(String username);
    void updateLoginDetailsPassword(UpdateDetailsRequest update);
    void deleteWebsiteDetails(DeleteWebsiteDetailsRequest deleteRequest);
}
