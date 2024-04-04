package africa.semoicolon.dtos.requests;

import lombok.Data;

@Data
public class LoginDetailsRequest{
    private String username;
    private String password;
}
