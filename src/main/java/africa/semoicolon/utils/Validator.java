package africa.semoicolon.utils;

import africa.semoicolon.dtos.requests.*;
import africa.semoicolon.exceptions.InvalidFieldException;

public class Validator{
    public static void validate(String userName){
        if(userName == null || userName.isBlank( ))
            throw new InvalidFieldException();
        userName = userName.strip();
    }
    public static void validateRegisterRequest(RegisterRequest request){
        validate(request.getFirstname());
        validate(request.getLastname());
        validate(request.getUsername());
        validate(request.getMasterPassword());
    }
    public static void validateUpdateRequest(UpdateDetailsRequest detailsRequest){
        validate(detailsRequest.getUsername());
        validate(detailsRequest.getPassword());
        validate(detailsRequest.getWebsiteName());
        validate(detailsRequest.getWebsitePassword());
    }
    public static void validateDeleteWebsiteRequest(DeleteWebsiteDetailsRequest deleteWebsiteDetailsRequest){
        validate(deleteWebsiteDetailsRequest.getPassword());
        validate(deleteWebsiteDetailsRequest.getWebsiteName());
        validate(deleteWebsiteDetailsRequest.getUsername());
    }
    public static void validatePasswordDetailsRequest(PasswordDetailsRequest request){
        validate(request.getUsername());
        validate(request.getPassword());
    }
    public static void validateLoginDetailsRequest(LoginDetailsRequest loginDetailsRequest){
        validate(loginDetailsRequest.getUsername( ));
        validate(loginDetailsRequest.getPassword( ));
    }
    public static void validateViewLoginDetails(ViewLoginDetailsRequest request){
        validate(request.getUsername( ));
        validate(request.getWebsiteName( ));
        validate(request.getMasterPassword( ));
    }
    public static void validateSavePasswordRequest(SavePasswordRequest request){
        validate(request.getWebsiteName());
        validate(request.getUserName());
        validate(request.getWebsiteUsername());
        validate(request.getWebsitePassword());
    }

    public static void validateRequest(ViewAllRequest request){
        validate(request.getUsername());
        validate(request.getPassword());
    }
}

