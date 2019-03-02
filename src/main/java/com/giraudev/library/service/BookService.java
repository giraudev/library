package com.giraudev.library.service;

import com.giraudev.library.converter.BookConverter;
import com.giraudev.library.domain.Book;
import com.giraudev.library.dto.BookDTO;
import com.giraudev.library.dto.BookPostResponse;
import com.giraudev.library.exception.BookNotFoundException;
import com.giraudev.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    BookConverter converter;

    @Autowired
    BookRepository repository;


    public BookDTO get(Long id) throws Exception{
        Book book = repository.findById(id).orElseThrow(() -> new BookNotFoundException());
        return converter.toDto(book);
    }

    public BookPostResponse post(BookDTO dto) {
        Book book = repository.findByIsbn(dto.getIsbn())
                .orElseGet(() -> this.repository.save(this.converter.fromRequestDTO(dto)));
        return converter.toDto(book.getId());
    }

    public List<BookDTO> getAll()throws Exception{
        List<Book> books = repository.findAll();
        Optional.of(!books.isEmpty()).orElseThrow(()-> new BookNotFoundException());

        return books.stream().map((entity) -> converter.toDto(entity)).collect(Collectors.toList());
    }
}

