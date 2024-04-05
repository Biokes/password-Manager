package africa.semoicolon.dtos.requests;

import lombok.Data;

@Data
public class DeleteWebsiteDetailsRequest{
    private String username;
    private String password;
    private String websiteName;
}
