package fi.haagahelia.bookstore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

import fi.haagahelia.bookstore.model.Book;
import fi.haagahelia.bookstore.model.BookRepository;
import fi.haagahelia.bookstore.model.Category;
import fi.haagahelia.bookstore.model.CategoryRepository;

@DataJpaTest
public class BookRepositoryTest {
    @Autowired
    private BookRepository repository;

    @Autowired
    private CategoryRepository crepository;

    @Test
    public void createNewBook() {
        Category fantasy = new Category("Fantasy");
        crepository.save(fantasy);

        Book book = new Book(
            "Harry Potter",
            "J.K. Rowling",
            1997, 
            "1234567",
            30,
            fantasy
            );
            repository.save(book);

            assertThat(book.getId()).isNotNull();
    }

}
