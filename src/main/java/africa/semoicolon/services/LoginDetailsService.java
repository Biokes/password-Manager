package africa.semoicolon.services;

import africa.semoicolon.dtos.requests.ViewLoginDetailsRequest;
import org.springframework.stereotype.Service;

@Service
public interface LoginDetailsService{
    void save(ViewLoginDetailsRequest viewLoginDetails);

    LoginDetailsResponse fetchDetails(ViewLoginDetailsRequest viewLoginDetails);
}
