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
    public boolean userExist(String username){
        return userRepository.findByUsername();
    }
    public List<User> findAll(){
        return userRepository.findAll() ;
    }
    public User findUser(String username){
        return userRepository.findUserByUsername(username);
    }
    public void deleteUser(User user){
        userRepository.delete(user);
    }

    private UsersRepository userRepository;


}
