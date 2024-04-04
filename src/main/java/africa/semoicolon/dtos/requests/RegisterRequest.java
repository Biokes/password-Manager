package africa.semoicolon.dtos.requests;


import lombok.Data;

@Data
public class RegisterRequest{
    private String firstname;
    private String lastname;
    private String username;
    private String masterPassword;

}
