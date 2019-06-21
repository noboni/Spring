package hello.service;

import hello.ResourceNotFoundException;
import hello.dao.BookDao;
import hello.entity.Book;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookDao bookDao;
    public Book get(ObjectId id) {
        System.out.println(bookDao.get(id));
        return bookDao.get(id);
    }

    public List<Book> getAll() {
        return bookDao.getAll();
    }
    public Book save(Book book) {
        return bookDao.save(book);
    }
    public void delete(ObjectId id) {
        Book book= bookDao.get(id);
        bookDao.delete(book);
    }
    public Book updateBook(ObjectId id,Book book){
        Book existingBook = bookDao.get(id);
        existingBook.setName(book.getName());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setPrice(book.getPrice());
        return bookDao.save(existingBook);
    }
}
