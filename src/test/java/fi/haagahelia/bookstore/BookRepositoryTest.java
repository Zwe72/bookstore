package fi.haagahelia.bookstore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fi.haagahelia.bookstore.model.BookRepository;
import fi.haagahelia.bookstore.model.Category;

public class BookRepositoryTest {
    @Autowired
    private BookRepository repository;

    @Test
    public void createNewBook() {
        Category category = new Category("Fantasy");
        //drepository.save(category);//
    }

}
