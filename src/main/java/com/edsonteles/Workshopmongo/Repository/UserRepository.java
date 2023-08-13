package com.edsonteles.Workshopmongo.Repository;

import com.edsonteles.Workshopmongo.Domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
