package africa.semoicolon.utils;

import africa.semoicolon.data.models.User;
import africa.semoicolon.data.models.WebsiteDetails;
import africa.semoicolon.dtos.reponses.LoginDetailsResponse;
import africa.semoicolon.dtos.reponses.ViewAllResponse;
import africa.semoicolon.dtos.requests.RegisterRequest;
import africa.semoicolon.dtos.requests.SavePasswordRequest;
import africa.semoicolon.dtos.requests.ViewAllRequest;
import africa.semoicolon.dtos.requests.ViewLoginDetailsRequest;
import africa.semoicolon.exceptions.InvalidFieldException;

import java.util.List;

import static africa.semoicolon.utils.Validator.validateRegisterRequest;

public class Mapper{
    public static User mapRegisterRequest(RegisterRequest request){
        User user = new User();
        validateRegisterRequest(request);
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setUsername(request.getUsername());
        user.setPassword(request.getMasterPassword());
        return user;
    }
    public static void mapViewLoginDetails(ViewLoginDetailsRequest viewLoginDetails){
        WebsiteDetails details = new WebsiteDetails();
    }

    public static WebsiteDetails mapSavePasswordRequest(SavePasswordRequest savePasswordRequest){
        WebsiteDetails websiteDetails = new WebsiteDetails();
        websiteDetails.setUsername(savePasswordRequest.getUserName( ));
        websiteDetails.setWebsiteName(savePasswordRequest.getWebsiteName());
        websiteDetails.setWebsiteUsername(savePasswordRequest.getWebsiteUsername());
        websiteDetails.setWebsitePassword(savePasswordRequest.getWebsitePassword( ));
        return websiteDetails;
    }

    public static LoginDetailsResponse mapLoginDetailsResponseWith(WebsiteDetails details){
        LoginDetailsResponse response = new LoginDetailsResponse();
        response.setWebsiteName(details.getWebsiteName());
        response.setWebsiteUsername(details.getWebsiteUsername());
        response.setWebsitePasssword(details.getWebsitePassword());
        return response;
    }

    public static ViewAllResponse mapDetails(List<WebsiteDetails> details){
        StringBuilder pack = new StringBuilder();
        ViewAllResponse response = new ViewAllResponse();
        for(WebsiteDetails details1 : details){
            pack.append(String.format("%s : %s\n%s : %s\n%s : %s\n",
                    "Website Name",details1.getWebsiteName(),
                    "Website Username",details1.getWebsiteUsername(),
                    "Website Password", details1.getWebsitePassword()));
        }
        response.setBody(pack.toString());
        return response;
    }
}
