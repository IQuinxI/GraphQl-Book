package ma.emsi.control.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import ma.emsi.control.dtos.BookDTO;
import ma.emsi.control.entities.Book;
import ma.emsi.control.mappers.BookMapper;
import ma.emsi.control.repositories.BookRepository;

/**
 * BookServiceImpl
 */
@Service
@AllArgsConstructor
@Transactional
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;
    private BookMapper bookMapper;

    @Override
    public List<BookDTO> getBookByTitle(String title) {
        List<BookDTO> booksList = bookRepository.findByTitle(title)
                .stream()
                .map(bookMapper::toBookDTO)
                .collect(Collectors.toList());
        return booksList;
    }

    @Override
    public List<BookDTO> getBookByPublisherAndPrice(String publisher, Float price) {
        List<BookDTO> books = bookRepository.findByPublisherAndPrice(publisher, price)
                .stream()
                .map(bookMapper::toBookDTO)
                .collect(Collectors.toList());
                
        System.out.println(books);
        return books;
    }

    @Override
    public BookDTO deleteBookById(Long id) {
        BookDTO deletedBook = bookMapper.toBookDTO( bookRepository.findById(id).get());
        bookRepository.deleteById(id);
        return deletedBook;
    }

    @Override
    public BookDTO saveBook(BookDTO book) {
        boolean bookExists = bookRepository.findByPublisherAndTitle(book.getPublisher(), book.getTitle()).size() != 0;
        if(bookExists) return null;
        Book newBook = bookMapper.toBook(book);
        bookRepository.save(newBook);
        return book;

    }
    
}