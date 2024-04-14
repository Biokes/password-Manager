package africa.semoicolon.dtos.reponses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse{
    private boolean isSuccessful;
    private Object message;
}
