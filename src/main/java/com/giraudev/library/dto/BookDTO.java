package com.giraudev.library.dto;

import com.giraudev.library.domain.Languages;

public class BookDTO {

    private Long id;

    private String title;

    private String description;

    private String isbn;

    private Languages language;

    @Deprecated
    BookDTO(){}

    public BookDTO(String title, String description, String isbn, Languages language) {
        this.title = title;
        this.description = description;
        this.isbn = isbn;
        this.language = language;
    }

    public BookDTO(Long id, String title, String description, String isbn, Languages language) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.isbn = isbn;
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getIsbn() {
        return isbn;
    }

    public Languages getLanguage() {
        return language;
    }

    public Long getId() {
        return id;
    }
}
