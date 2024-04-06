package africa.semoicolon.controller;

import africa.semoicolon.dtos.reponses.LoginDetailsResponse;
import africa.semoicolon.dtos.requests.*;
import africa.semoicolon.exceptions.PasswordSaverException;
import africa.semoicolon.services.PasswordManagerServices;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.HttpStatus.*;

@RestController
@AllArgsConstructor
@RequestMapping("/password-saver")
public class PasswordSaverController{
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
    public ResponseEntity<?> deleteAccount(@RequestBody LoginDetailsRequest loginDetails){
        try{
            userService.deleteUser(loginDetails);
        }
        catch(PasswordSaverException error){
            return new ResponseEntity<>(error.getMessage(), BAD_REQUEST);
        }
        return new ResponseEntity<>("",OK);
    }
    @PatchMapping("/save-password")
    public ResponseEntity<?> addPassword(@RequestBody SavePasswordRequest savePasswordRequest){
        try{
            userService.saveLoginDetails(savePasswordRequest);
            return new ResponseEntity<>("Saved successfully", OK);
        }catch(PasswordSaverException error){
            return new ResponseEntity<>(error.getMessage(), BAD_REQUEST);
        }
    }
    @PatchMapping("/update-website-password")
    public ResponseEntity<?> updateWebsitePasssword(@RequestBody UpdateDetailsRequest updateDetailsRequest){
        try{
            userService.updateLoginDetails(updateDetailsRequest);
        }catch( PasswordSaverException error ){
            return new ResponseEntity<>(error.getMessage( ), BAD_REQUEST);
        }
        return new ResponseEntity<>("Updated succefully", OK);
    }
    @GetMapping("/view-password-saved")
    public ResponseEntity<?> viewPasswordDetails(@RequestBody ViewLoginDetailsRequest viewLoginDetailsRequest){
        try{
            LoginDetailsResponse response=userService.fetchDetails(viewLoginDetailsRequest);
            return new ResponseEntity<>(String.format("%s : %s\n%s : %s\n%s : %s","Website name",response.getWebsiteName( ),
                    "Website Username",response.getWebsiteUsername( ), "Website Password",response.getWebsitePasssword( )), OK);
        }catch(PasswordSaverException error){
            return new ResponseEntity<>(error.getMessage(), BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete-password-saved")
    public ResponseEntity<?> deletePasswordDetails(@RequestBody DeleteWebsiteDetailsRequest detailsRequest){
        try{
        userService.deletePasswordDetails(detailsRequest);
        return new ResponseEntity<>("deleted successfully", OK);
        }
        catch(PasswordSaverException error){
            return new ResponseEntity<>(error.getMessage(), BAD_REQUEST);
        }
    }
    @GetMapping("/view-all-passwords")
    public ResponseEntity<?> viewAllPassword(){
        try{}
        catch(PasswordSaverException error){
            return new ResponseEntity<>(error.getMessage(), BAD_REQUEST);
        }
    }
}
