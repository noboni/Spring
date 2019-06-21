package hello.dao;

import hello.entity.Book;
import hello.repository.BookRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {
    @Autowired
    BookRepository bookRepository;
    public Book get(ObjectId id) {
        return bookRepository.findBy_id(id);
    }

    public List<Book> getAll() {
        return bookRepository.findAll();
    }
    public Book save(Book book) {
        return bookRepository.save(book);
    }
    public void delete(Book book) {
        bookRepository.delete(book);
    }
}
