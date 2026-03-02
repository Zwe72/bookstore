package fi.haagahelia.bookstore.controller;


import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fi.haagahelia.bookstore.model.Book;
import fi.haagahelia.bookstore.model.BookRepository;
import fi.haagahelia.bookstore.model.Category;
import fi.haagahelia.bookstore.model.CategoryRepository;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;







@Controller
public class BookController {
    private BookRepository repository;
    private CategoryRepository catrepository;
    private final AtomicLong counter = new AtomicLong();

    public BookController(BookRepository repository, CategoryRepository catrepository) {
        this.repository = repository;
        this.catrepository = catrepository;
    }

    @RequestMapping("/books")
    public @ResponseBody List <Book> allBooks() { 
        return (List<Book>) repository.findAll();
    }

    @RequestMapping("/books/{id}")
    public @ResponseBody Optional<Book> findBook(@PathVariable("id") Long bookId) {

        return repository.findById(bookId);
    }

    @JsonIgnoreProperties("books")
    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;
    
    @GetMapping("/booklist")
    public String bookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }
    
    @GetMapping("/addbook")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", catrepository.findAll() );
        return "addbook";
    }

    @PostMapping("/savebook")
    public String save(Book book) {
        repository.save(book);
        return "redirect:/booklist";
    }

    @GetMapping("/deletebook/{id}")
    public String deleteBook(@PathVariable() Long id) {
        repository.deleteById(id);
        return "redirect:/booklist";
    }
    
    @GetMapping("/editbook/{id}")
    public String editBook(@PathVariable() Long id, Model model) {
        Book book = repository.findById(id).orElse(null);
        model.addAttribute("book", book);
        model.addAttribute("categories", catrepository.findAll());
        return "addbook";
    }
    
    
    @RequestMapping("/index")
        public String showIndex() {
            return "index";
        }
}

