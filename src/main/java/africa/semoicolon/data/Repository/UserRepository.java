package africa.semoicolon.data.Repository;

import africa.semoicolon.data.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String>{

}
