package fi.haagahelia.bookstore.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fi.haagahelia.bookstore.model.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class BookController {
    private BookRepository repository;
    public BookController(BookRepository repository) {
        this.repository = repository;
    }
    
    @GetMapping("/booklist")
    public String bookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }
    
    
    @RequestMapping("/index")
        public String showIndex() {
            return "index";
        }
}

