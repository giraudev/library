package com.giraudev.library.service;

import com.giraudev.library.Repository.BookRepository;
import com.giraudev.library.converter.BookConverter;
import com.giraudev.library.domain.Book;
import com.giraudev.library.dto.BookDTO;
import com.giraudev.library.exception.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookConverter converter;

    @Autowired
    BookRepository repository;

    @Autowired
    Crawler crawler;

    public BookDTO getBook(Long id) {
        Book book = repository.findById(id).orElseThrow(() -> new BookNotFoundException());
        return converter.toDto(book);
    }

    public void postBook(BookDTO dto) {
        Book book = converter.fromRequestDTO(dto);
        repository.save(book);
    }

    public BookDTO getBooks() {
        crawler.getPageLinks("https://kotlinlang.org/docs/books.html");
        return null;
    }
}

