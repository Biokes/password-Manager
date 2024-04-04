package africa.semoicolon.services;

import africa.semoicolon.dtos.requests.RegisterRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserService{
    void registerUser(RegisterRequest request);
    long count();
}
