package fi.haagahelia.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fi.haagahelia.bookstore.controller.BookController;
import fi.haagahelia.bookstore.controller.BookRestController;

@SpringBootTest
class BookstoreApplicationTests {
	@Autowired
	private BookController controller;

	@Autowired
	private BookRestController bookRestController;

	@Test
	public void contextLoads() {
		
	}

	@Test
	public void bookControllerLoads() {
		assertThat(controller).isNotNull();
	}

	@Test
	public void bookRestControllerLoads() {
		assertThat(bookRestController).isNotNull();
	}
}
