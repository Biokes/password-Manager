package africa.semoicolon.services;

import africa.semoicolon.data.models.User;
import africa.semoicolon.data.repositories.UsersRepository;

import africa.semoicolon.dtos.requests.RegisterRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import africa.semoicolon.utils.Mapper;

import java.util.List;

@Service
@AllArgsConstructor
public class PasswordSaverUserService implements UserService{
    public void registerUser(RegisterRequest request){
       User userMapped = Mapper.mapRegisterRequest(request);
       userRepository.save(userMapped);
    }
    public long count(){
        return userRepository.count();
    }
    public void deleteAll(){
        userRepository.deleteAll();
    }

    @Override
    public boolean userExist(String username){
        return userRepository.findByUsername();
    }

    @Override
    public List<User> findAll(){
        return userRepository.findAll() ;
    }

    private UsersRepository userRepository;


}
