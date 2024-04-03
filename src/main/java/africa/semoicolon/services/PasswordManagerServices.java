package africa.semoicolon.services;

import africa.semoicolon.data.Models.User;
import africa.semoicolon.data.Repository.PasswordRepository;
import africa.semoicolon.data.Repository.UserRepository;
import africa.semoicolon.dtos.RegisterRequest;
import africa.semoicolon.utils.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PasswordManagerServices implements PasswordServices{
    public void save(RegisterRequest request){
        User user = Mapper.mapRegister(request);
        service.save(user);
    }

    private UserService service;


}
