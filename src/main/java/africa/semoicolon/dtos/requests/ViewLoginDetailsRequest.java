package africa.semoicolon.dtos.requests;

import lombok.Data;

@Data
public class ViewLoginDetailsRequest{
    private String username;
    private String websiteName;
    private String masterPassword;
}
