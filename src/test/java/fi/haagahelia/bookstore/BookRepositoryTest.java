package fi.haagahelia.bookstore;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import fi.haagahelia.bookstore.model.Book;
import fi.haagahelia.bookstore.model.BookRepository;
import fi.haagahelia.bookstore.model.Category;
import fi.haagahelia.bookstore.model.CategoryRepository;

@SpringBootTest
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

    @Test
    public void DeleteBook() {
        Category fantasy = new Category("Fantasy");
        crepository.save(fantasy);

        Book book = new Book(
            "Delete",
            "Test",
            2000,
            "999999",
            20,
            fantasy
        );

        repository.save(book);

        Long id = book.getId();
        repository.deleteById(id);

        assertThat(repository.findById(id)).isEmpty();
    }

    @Test
    public void findByTitleBook() {
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

        List<Book> books = repository.findByTitle("Harry Potter");

        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("J.K. Rowling");
    }
}
