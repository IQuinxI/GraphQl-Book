package ma.emsi.control.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import ma.emsi.control.dtos.BookDTO;
import ma.emsi.control.entities.Book;

/**
 * BookMapper
 */
@Component
public class BookMapper {
    ModelMapper modelMapper = new ModelMapper();

    public Book toBook(BookDTO bookDTO) {
        return modelMapper.map(bookDTO, Book.class);
    }

    public BookDTO toBookDTO(Book book) {
        return modelMapper.map(book, BookDTO.class);
    }

    
}