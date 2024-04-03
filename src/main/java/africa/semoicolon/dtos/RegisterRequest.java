package africa.semoicolon.dtos;

import lombok.Data;

@Data
public class RegisterRequest{
    private String username;
    private String masterPassword;
}
