package africa.semoicolon.data.repositories;

import africa.semoicolon.data.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<User, String>{
}
