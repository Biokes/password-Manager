package africa.semoicolon.dtos.requests;

import lombok.Data;

@Data
public class UpdateDetailsRequest{
    private String username;
    private String password;
    private String websiteName;
    private String websitePassword;
}
