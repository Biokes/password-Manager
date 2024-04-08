package africa.semoicolon.controller;

import africa.semoicolon.dtos.reponses.LoginDetailsResponse;
import africa.semoicolon.dtos.reponses.ViewAllResponse;
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
    private PasswordManagerServices passwordManagerServices;
    @PostMapping("/Register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request){
        try{
          passwordManagerServices.register(request);
            return new ResponseEntity<>("User Registered successfully", CREATED);
        }
        catch(PasswordSaverException exceptions){
            return new ResponseEntity<>(exceptions.getMessage(), BAD_REQUEST);
        }
    }
    @DeleteMapping("/Delete-Account")
    public ResponseEntity<?> deleteAccount(@RequestBody LoginDetailsRequest loginDetails){
        try{
            passwordManagerServices.deleteUser(loginDetails);
        }
        catch(PasswordSaverException error){
            return new ResponseEntity<>(error.getMessage(), BAD_REQUEST);
        }
        return new ResponseEntity<>(loginDetails.getUsername()+" Deleted successfully",OK);
    }
    @PutMapping("/save-password")
    public ResponseEntity<?> addPassword(@RequestBody SavePasswordRequest savePasswordRequest){
        try{
            passwordManagerServices.saveLoginDetails(savePasswordRequest);
            return new ResponseEntity<>("Saved successfully", OK);
        }catch(PasswordSaverException error){
            return new ResponseEntity<>(error.getMessage(), BAD_REQUEST);
        }
    }
    @PatchMapping("/update-website-password")
    public ResponseEntity<?> updateWebsitePassword(@RequestBody UpdateDetailsRequest updateDetailsRequest){
        try{
            passwordManagerServices.updateLoginDetails(updateDetailsRequest);
        }catch( PasswordSaverException error ){
            return new ResponseEntity<>(error.getMessage( ), BAD_REQUEST);
        }
        return new ResponseEntity<>("Updated successfully", OK);
    }
    @GetMapping("/view-password-saved")
    public ResponseEntity<?> viewPasswordDetails(@RequestBody ViewLoginDetailsRequest viewLoginDetailsRequest){
        try{
            LoginDetailsResponse response=passwordManagerServices.fetchDetails(viewLoginDetailsRequest);
            return new ResponseEntity<>(String.format("%s : %s\n%s : %s\n%s : %s","Website name",response.getWebsiteName( ),
                    "Website Username",response.getWebsiteUsername( ), "Website Password",response.getWebsitePasssword( )), OK);
        }catch(PasswordSaverException error){
            return new ResponseEntity<>(error.getMessage(), BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete-password-saved")
    public ResponseEntity<?> deletePasswordDetails(@RequestBody DeleteWebsiteDetailsRequest detailsRequest){
        try{
        passwordManagerServices.deletePasswordDetails(detailsRequest);
        return new ResponseEntity<>("deleted successfully", OK);
        }
        catch(PasswordSaverException error){
            return new ResponseEntity<>(error.getMessage(), BAD_REQUEST);
        }
    }
    @GetMapping("/view-all-passwords")
    public ResponseEntity<?> viewAllPassword(@RequestBody ViewAllRequest viewAllRequest){
        try{
            ViewAllResponse response = passwordManagerServices.viewAllDetails(viewAllRequest);
            return new ResponseEntity<>(response.getBody(),OK);
        }
        catch(PasswordSaverException error){
            return new ResponseEntity<>(error.getMessage(), BAD_REQUEST);
        }
    }
}
