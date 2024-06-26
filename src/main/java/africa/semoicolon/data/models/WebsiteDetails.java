package africa.semoicolon.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("WebsiteDetails")
public class WebsiteDetails{
    @Id
    private String id;
    private String username;
    private String websiteUsername;
    private String websitePassword;
    private String websiteName;
}
