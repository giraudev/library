package com.giraudev.library.converter;

import com.giraudev.library.domain.Book;
import com.giraudev.library.dto.BookDTO;
import org.springframework.stereotype.Component;

@Component
public class BookConverter {

    public Book fromRequestDTO(BookDTO bookDTO){
        return new Book(bookDTO.getTitle(), bookDTO.getDescription(), bookDTO.getIsbn(), bookDTO.getLanguage());
    }

    public BookDTO toDto(Book book){
        return new BookDTO(book.getId(), book.getTitle(), book.getDescription(), book.getIsbn(), book.getLanguage());
    }

}
