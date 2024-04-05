package africa.semoicolon.data.repositories;

import africa.semoicolon.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<User, String>{
    boolean existsUserByUsername(String username);

    User findUserByUsername(String username);
}
