package africa.semoicolon.data.Repository;

import africa.semoicolon.data.Models.LoginDetails;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface PasswordRepository extends MongoRepository<LoginDetails, String >{
}
