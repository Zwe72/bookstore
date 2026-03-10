package fi.haagahelia.bookstore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import fi.haagahelia.bookstore.model.Book;
import fi.haagahelia.bookstore.model.BookRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api")
public class BookRestController {

    private final BookRepository repository;

    public BookRestController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/books")
    public List<Book> bookListRest() {
        return (List<Book>) repository.findAll();
    }
    
    @GetMapping("/books/{id}")
    public Optional<Book> findBookRest(@PathVariable("id") Long bookId){
        return repository.findById(bookId);}

    @PostMapping("/books")
    public Book newBook(@RequestBody Book newBook) {
        
        return repository.save(newBook);
    }

    @PutMapping("/books/{id}")
    public Book editBook(@PathVariable Long id, @RequestBody Book editedBook) {
        editedBook.setId(id);
        return repository.save(editedBook);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Long id) {
        repository.deleteById(id);
    }
    
}
