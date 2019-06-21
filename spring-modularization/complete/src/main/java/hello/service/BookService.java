package hello.service;

import hello.ResourceNotFoundException;
import hello.entity.Book;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Book get(ObjectId id);

    List<Book> getAll();
    Book save(Book book);
    void delete(ObjectId id);
    Book updateBook(ObjectId id,Book book);
}
