package fi.haagahelia.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import fi.haagahelia.model.Book;

@Controller
public class BookController {
    private List<Book> books = new ArrayList<>();
    @GetMapping("/naytalomake")
    public String naytaLomake(Model model){

        model.addAttribute(model);
        return "booklist";
    }
}

@PostMapping("/naytalomake")
public String naytaArvot(@ModelAttribute Book book, Model model) {
    model.addAttribute(model)
    return "booklist";
}
@PostMapping("/naytalomake")
    public String naytaArvot(ModelAttribute Book book, Model model) {
        model.addAttribute("insertedbook", book);
        add.List()


    }
)
