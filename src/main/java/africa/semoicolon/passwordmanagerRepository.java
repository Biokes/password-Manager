package africa.semoicolon;

import africa.semoicolon.dto.LoginDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface passwordmanagerRepository extends MongoRepository<LoginDetails, String >{
}
