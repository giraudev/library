package com.giraudev.library.dto;

public class BookPostResponse {

    private Long id;

    @Deprecated
    BookPostResponse(){}

    public BookPostResponse(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
