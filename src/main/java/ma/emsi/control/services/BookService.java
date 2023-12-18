package ma.emsi.control.services;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;

import ma.emsi.control.dtos.BookDTO;

/**
 * BookService
 */
public interface BookService {

    public List<BookDTO> getBookByTitle(String title);
    public List<BookDTO> getBookByPublisherAndPrice(String publisher, Float price);
    public BookDTO deleteBookById(Long id) ;
    public BookDTO saveBook(BookDTO book);
}