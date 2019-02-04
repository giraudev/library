package com.giraudev.library.dto;

import java.util.List;

public class BookResponseURLDTO {

    private Long numberBooks;

    private List<BookDTO> books;

    @Deprecated
            BookResponseURLDTO(){}

    public BookResponseURLDTO(Long numberBooks, List<BookDTO> books) {
        this.numberBooks = numberBooks;
        this.books = books;
    }

    public Long getNumberBooks() {
        return numberBooks;
    }

    public List<BookDTO> getBooks() {
        return books;
    }
}
