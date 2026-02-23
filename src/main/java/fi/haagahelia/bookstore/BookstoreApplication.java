package fi.haagahelia.bookstore;

import fi.haagahelia.bookstore.model.Category;
import fi.haagahelia.bookstore.model.CategoryRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.bookstore.model.Book;
import fi.haagahelia.bookstore.model.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository,
								CategoryRepository categoryRepository)
	 {
		return (args) -> {

			Category programming = new Category("Programming");
        Category fiction = new Category("Fiction");
        Category manga = new Category("Manga");
			
			bookRepository.save(new Book(
				"Clean Code", 
				"Robert C. Martin",
				2008,
				"9780132350884",
				39.90,
				programming
			));

			bookRepository.save(new Book(
			"The Hobbit",
        	"J.R.R. Tolkien",
        1937,
        	"9780547928227",
        	14.90,
        fiction
			));

			bookRepository.save(new Book(
                "Naruto Vol.1",
                "Masashi Kishimoto",
                2000,
                "1111111111",
                9.90,
				manga
            ));


		};
	}

}
