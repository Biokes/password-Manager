package africa.semoicolon.services;

import africa.semoicolon.data.Models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService{
    void save(User user);

}
