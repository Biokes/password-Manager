package africa.semoicolon.services;

import africa.semoicolon.data.models.User;
import africa.semoicolon.dtos.requests.RegisterRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService{
    void registerUser(RegisterRequest request);
    long count();
    void deleteAll();
    boolean userExist(String username);
    List<User> findAll();
    User findUser(String username);
    void deleteUser(User user);
}
