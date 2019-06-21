package hello.repository;

import hello.entity.Book;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book,String> {
    Book findBy_id(ObjectId _id);
}
