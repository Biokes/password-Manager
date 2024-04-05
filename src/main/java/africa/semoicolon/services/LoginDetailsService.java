package africa.semoicolon.services;

import africa.semoicolon.dtos.reponses.LoginDetailsResponse;
import africa.semoicolon.dtos.requests.SavePasswordRequest;
import africa.semoicolon.dtos.requests.ViewLoginDetailsRequest;
import org.springframework.stereotype.Service;

@Service
public interface LoginDetailsService{
    void save(SavePasswordRequest savePasswordRequest);

    LoginDetailsResponse fetchDetails(ViewLoginDetailsRequest viewLoginDetails);

    void deleteAll();
}
