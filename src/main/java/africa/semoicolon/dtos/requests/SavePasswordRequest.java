package africa.semoicolon.dtos.requests;

import lombok.Data;

@Data
public class SavePasswordRequest{
    private String userName;
    private String websiteName;
    private String websiteUsername;
    private String websitePassword;
}
