package africa.semoicolon.utils;

import africa.semoicolon.dtos.requests.RegisterRequest;
import africa.semoicolon.dtos.requests.UpdateDetailsRequest;
import africa.semoicolon.exceptions.InvalidFieldException;

public class Validator{
    public static void validate(String userName){
        if(userName.isEmpty())
            throw new InvalidFieldException();
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
}
