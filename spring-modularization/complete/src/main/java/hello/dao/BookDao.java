package hello.dao;

import hello.entity.Book;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface BookDao {
    Book get(ObjectId id);
    List<Book> getAll();
    Book save(Book device);
    void delete(Book device);
}
