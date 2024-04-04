package africa.semoicolon.data.Models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("User")
public class User{
    private String username;

    private String password;
}
