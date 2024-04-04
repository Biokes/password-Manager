package africa.semoicolon.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("users")
public class User{
    @Id
    private String id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;

}
