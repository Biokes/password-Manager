package africa.semoicolon.utils;

import africa.semoicolon.dtos.requests.UpdateDetailsRequest;
import africa.semoicolon.exceptions.InvalidFieldException;

public class Validator{
    public static void validateUpdateRequest(UpdateDetailsRequest detailsRequest){
        if( detailsRequest.getUsername().isBlank()) throw new InvalidFieldException("username field is required");
        if(detailsRequest.getPassword().isBlank())throw new InvalidFieldException("password field is required");
        if(detailsRequest.getWebsiteName().isBlank()) throw new InvalidFieldException("Website name field is required");
        if(detailsRequest.getWebsitePassword().isBlank())throw new InvalidFieldException("website password field is required");
    }
}
