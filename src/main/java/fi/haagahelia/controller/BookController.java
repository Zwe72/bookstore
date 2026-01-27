package fi.haagahelia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class BookController {
    @GetMapping("/naytalomake")
    public String naytaLomake(Model model){

        model.addAttribute(model);
        return "booklist";
    }
}
