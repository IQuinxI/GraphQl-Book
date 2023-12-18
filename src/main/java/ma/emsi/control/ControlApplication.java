package ma.emsi.control;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import jakarta.transaction.Transactional;
import ma.emsi.control.entities.Book;
import ma.emsi.control.repositories.BookRepository;

@SpringBootApplication
public class ControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControlApplication.class, args);
	}

	@Transactional
	@Bean
	CommandLineRunner run(BookRepository bookRepository) {
		return args -> {
			bookRepository.save(Book.builder()
					.title("title1")
					.publisher("publisher1")
					.datePublication(LocalDate.now())
					.price(12f)
					.resume("resume1")
					.build());

			bookRepository.save(Book.builder()
					.title("title2")
					.publisher("publisher2")
					.datePublication(LocalDate.now())
					.price(2f)
					.resume("resume2")
					.build());
		};
	}
}
