package africa.semoicolon.data.repositories;

import africa.semoicolon.data.models.WebsiteDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LoginDetailsBank extends MongoRepository<WebsiteDetails, String>{
    List<WebsiteDetails> findByUsername(String username);
    void deleteByWebsiteName(String websiteName);
}
