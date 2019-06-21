package hello.api;

import hello.ResourceNotFoundException;
import hello.entity.Book;
import hello.entity.Book;
import hello.model.BookRequestModel;
import hello.model.BookResponseModel;
import hello.repository.BookRepository;
import hello.service.BookService;
import hello.service.ServiceLocator;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path="/api")
public class BookController {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    BookService bookService;
    @GetMapping(path="/books")
    public Iterable<BookResponseModel> getAllBooks() {
        return bookService.getAll().stream().map(book -> modelMapper.map(book, BookResponseModel.class)).collect(Collectors.toList());

    }
    @CachePut(value = "book-single", key = "#result._id")
    @PostMapping(path="/book")
    public BookResponseModel addBook(@RequestBody BookRequestModel bookRequestModel){
        Book book=modelMapper.map(bookRequestModel,Book.class);
        return modelMapper.map(bookService.save(book),BookResponseModel.class);

    }
    @Cacheable(value = "book-single", key = "#id")
    @GetMapping(path = "/book/{id}")
    public BookResponseModel getById(@PathVariable ObjectId id) {
        return modelMapper.map(bookService.get(id),BookResponseModel.class);
    }
    @CachePut(value = "book-single", key = "#id")
    @PutMapping(path="/book/{id}")
    public BookResponseModel updateBook(@PathVariable ObjectId id, @RequestBody BookRequestModel bookRequestModel) throws ResourceNotFoundException {
        Book book=modelMapper.map(bookRequestModel,Book.class);
        return modelMapper.map(bookService.updateBook(id,book),BookResponseModel.class);

    }
    @CacheEvict(value = "book-single", key = "#id")
    @DeleteMapping(path="/book/{id}")
    public void deleteBook(@PathVariable ObjectId id) throws ResourceNotFoundException {
        bookService.delete(id);
    }
}
