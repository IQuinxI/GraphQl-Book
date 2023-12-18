package ma.emsi.control.controllers;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import lombok.AllArgsConstructor;
import ma.emsi.control.dtos.BookDTO;
import ma.emsi.control.services.BookService;

/**
 * BookGraphQlController
 */
@AllArgsConstructor
@Controller
public class BookGraphQlController {
    private BookService bookService;

    @QueryMapping
    public List<BookDTO> getBookByTitle(@Argument String title) {
        return bookService.getBookByTitle(title);
    }

    @QueryMapping
    public List<BookDTO> getBookByPublisherAndPrice(@Argument String publisher,@Argument Float price) {
        return bookService.getBookByPublisherAndPrice(publisher, price);
    }

    @MutationMapping
    public BookDTO deleteBook(@Argument Long id) {
        return bookService.deleteBookById(id);
    }

    @MutationMapping
    public BookDTO saveBook(@Argument BookDTO book) {
        return bookService.saveBook(book);
    }
}