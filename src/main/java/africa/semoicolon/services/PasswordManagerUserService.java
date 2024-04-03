package africa.semoicolon.services;

import africa.semoicolon.data.Models.User;
import africa.semoicolon.data.Repository.UserRepository;
import africa.semoicolon.dtos.RegisterRequest;
import africa.semoicolon.utils.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PasswordManagerUserService implements UserService{
    public void register(RegisterRequest request){
        User user = Mapper.mapRegister(request);
        reposoitory.save(user);
    }

    private UserRepository reposoitory;

}
