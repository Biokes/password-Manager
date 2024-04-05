package africa.semoicolon.controller;

import africa.semoicolon.dtos.requests.RegisterRequest;
import africa.semoicolon.exceptions.PasswordSaverException;
import africa.semoicolon.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@AllArgsConstructor
@RequestMapping("/password-saver")
public class PasswordSaverController{
    private UserService userService;
    @PostMapping("/Register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request){
        try{
          userService.registerUser(request);
            return new ResponseEntity<>("User Registered successfully", CREATED);
        }
        catch(PasswordSaverException exceptions){
            return new ResponseEntity<>(exceptions.getMessage(), BAD_REQUEST);
        }

    }

}
