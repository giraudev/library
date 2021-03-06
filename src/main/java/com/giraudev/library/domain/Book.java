package com.giraudev.library.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "BOOK")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "ISBN")
    private String isbn;

    @NotNull
    @Column(name = "LANGUAGE")
    private String language;

    @Column(name = "CREATED_TIME")
    private LocalDateTime createdTime;

    @Deprecated
    Book(){}

    public Book(String title, String description, String isbn, String language) {
        this.title = title;
        this.description = description;
        this.isbn = isbn;
        this.language = language;
        this.createdTime = LocalDateTime.now();
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

    public String getLanguage() {
        return language;
    }

    public Long getId(){
        return id;
    }
}
