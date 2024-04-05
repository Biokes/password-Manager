package africa.semoicolon.controller;

import africa.semoicolon.dtos.requests.RegisterRequest;
import africa.semoicolon.exceptions.PasswordSaverException;
import africa.semoicolon.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/password-saver")
public class PasswordSaverController{
    private UserService userService;
    @PostMapping("/Register")
    public String register(@RequestBody RegisterRequest request){
        try{
            userService.registerUser(request);
            return "Successfully Registered";
        }
        catch(PasswordSaverException exceptions){
            return exceptions.getMessage( );
        }

    }
}
