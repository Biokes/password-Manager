package africa.semoicolon.controller;

import africa.semoicolon.dtos.requests.RegisterRequest;
import africa.semoicolon.exceptions.PasswordSaverException;
import africa.semoicolon.services.PasswordManagerServices;
import africa.semoicolon.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@AllArgsConstructor
@RequestMapping("/password-saver")
public class PasswordSaverController{
    @Qualifier("passwordManagerServices")
    private PasswordManagerServices userService;
    @PostMapping("/Register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request){
        try{
          userService.register(request);
            return new ResponseEntity<>("User Registered successfully", CREATED);
        }
        catch(PasswordSaverException exceptions){
            return new ResponseEntity<>(exceptions.getMessage(), BAD_REQUEST);
        }
    }
    @DeleteMapping("/Delete-Account")
    public ResponseEntity<?> deleteAccount(){

    }

}
