package africa.semoicolon.dtos.requests;

import lombok.Data;

@Data
public class PasswordDetailsRequest{
    private String username;
    private String password;
}
