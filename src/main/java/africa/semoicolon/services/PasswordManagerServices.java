package africa.semoicolon.services;

import africa.semoicolon.dtos.reponses.LoginDetailsResponse;
import africa.semoicolon.dtos.requests.*;
import org.springframework.stereotype.Service;

@Service
public interface PasswordManagerServices{
    void register(RegisterRequest request);
    long countUsers();
    long countLoginDetailsOfUser(PasswordDetailsRequest passwordDetailsRequest);
    long countUserLoginDetails(LoginDetailsRequest loginDetails);
    void saveLoginDetails(SavePasswordRequest savePasswordRequest);
    LoginDetailsResponse fetchDetails(ViewLoginDetailsRequest viewLoginDetails);
    void wipeAll();
    void updateLoginDetails(UpdateDetailsRequest update);
    void deletePasswordDetails(DeleteWebsiteDetailsRequest deleteRequest);
    void deleteUser(LoginDetailsRequest loginRequest);
}
