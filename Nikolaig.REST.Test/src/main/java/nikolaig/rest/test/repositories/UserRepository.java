package nikolaig.rest.test.repositories;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


import nikolaig.rest.test.model.Task;
import nikolaig.rest.test.model.User;

public interface UserRepository extends MongoRepository<User, String> {
	
 
	User findBy_id(ObjectId _id);

}
