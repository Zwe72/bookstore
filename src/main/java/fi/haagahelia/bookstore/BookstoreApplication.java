package fi.haagahelia.bookstore;

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
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			repository.save(new Book(
				"Clean Code", 
				"Robert C. Martin",
				2008,
				"9780132350884",
				39.90
			));

			repository.save(new Book(
				"Spring in Action", 
				"Craig Walls",
				2022,
				"9781617297571",
				49.90
			));

			repository.save(new Book(
				"Effective Java", 
				"Joshua Bloch",
				2018,
				"9780134685991",
				45.50
			));


		};
	}

}
