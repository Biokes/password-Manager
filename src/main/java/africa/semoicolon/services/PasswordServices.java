package africa.semoicolon.services;

import africa.semoicolon.dtos.RegisterRequest;
import org.springframework.stereotype.Service;

@Service
public interface PasswordServices{
    void save(RegisterRequest request);

}

