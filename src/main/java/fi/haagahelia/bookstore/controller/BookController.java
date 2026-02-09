package fi.haagahelia.bookstore.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fi.haagahelia.bookstore.model.BookRepository;



@Controller
public class BookController {
    private BookRepository repository;
    public BookController(BookRepository repository) {
        this.repository = repository;
    }
    
    //@requestMapping(value() = {"/", "/booklist"})
    //public String booklist(Model model) {
        //model.addAttribute("books", repository.findAll());
    //}
    
    @RequestMapping("/index")
        public String showIndex() {
            return "index";
        }
}

