package africa.semoicolon.services;

import africa.semoicolon.data.Models.User;
import africa.semoicolon.data.Repository.UserRepository;
import africa.semoicolon.dtos.RegisterRequest;
import africa.semoicolon.utils.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SecurityUserService implements UserService{
    public void register(RegisterRequest request){
        User user = Mapper.mapRegister(request);
        repository.save(user);
    }

    @Override
    public long countAllUsers(){
        return repository.count();
    }

    private UserRepository repository;
}
