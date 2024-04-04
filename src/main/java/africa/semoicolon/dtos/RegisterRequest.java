package africa.semoicolon.dtos;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class RegisterRequest{
    @Id
    private String id;
    private String username;
    private String masterPassword;
}
