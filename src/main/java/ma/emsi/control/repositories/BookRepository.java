package ma.emsi.control.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.emsi.control.entities.Book;

/**
 * BookRepository
 */
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitle(String title);
    List<Book> findByPublisher(String publisher);
    List<Book> findByPublisherAndPrice(String publisher, Float price);
    List<Book> findByPublisherAndTitle(String publisher, String title);
}