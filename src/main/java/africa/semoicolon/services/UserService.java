package africa.semoicolon.services;

import africa.semoicolon.data.Models.User;
import africa.semoicolon.dtos.RegisterRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserService{
    void register(RegisterRequest request);
}
