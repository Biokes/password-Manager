package africa.semoicolon.services;

import africa.semoicolon.dtos.requests.LoginDetailsRequest;
import africa.semoicolon.dtos.requests.PasswordDetailsRequest;
import africa.semoicolon.dtos.requests.RegisterRequest;
import africa.semoicolon.dtos.requests.SavePasswordRequest;
import org.springframework.stereotype.Service;

@Service
public interface PasswordManagerServices{
    void register(RegisterRequest request);
    long countUsers();

    long countLoginDetailsOfUser(PasswordDetailsRequest passwordDetailsRequest);

    long countUserLoginDetails(LoginDetailsRequest loginDetails);

    void saveLoginDetails(SavePasswordRequest savePasswordRequest);
}
