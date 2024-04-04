package africa.semoicolon.data.repositories;

import africa.semoicolon.data.models.WebsiteDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoginDetailsBank extends MongoRepository<WebsiteDetails, String>{
}
