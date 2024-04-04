package africa.semoicolon.services;

import africa.semoicolon.data.models.User;
import africa.semoicolon.data.repositories.UsersRepository;
import africa.semoicolon.dtos.reponses.RegisterResponse;
import africa.semoicolon.dtos.requests.RegisterRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import africa.semoicolon.utils.Mapper;

@Service
public class PasswordSaverUserService implements UserService{
    public void registerUser(RegisterRequest request){
       User userMapped = Mapper.mapRegisterRequest(request);
       userRepository.save(userMapped);
    }
    public long count(){
        return userRepository.count();
    }
    @Autowired
    private UsersRepository userRepository;
}
