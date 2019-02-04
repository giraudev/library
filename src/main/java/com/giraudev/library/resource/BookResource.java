package com.giraudev.library.resource;

import com.giraudev.library.dto.BookDTO;
import com.giraudev.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/library")
public class BookResource {

    @Autowired
    BookService service;

    @PostMapping(path = "/book")
    public ResponseEntity<Void>postBook(@RequestBody BookDTO dto){
        service.postBook(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/book/{id}")
    public ResponseEntity<BookDTO>getBook(@PathVariable("id") Long id){
        BookDTO dto = service.getBook(id);
        return new ResponseEntity<>( dto, HttpStatus.OK);    }


//    @GetMapping(path = "/book")
//    public ResponseEntity<BookDTO>getAllBooks(@PathVariable("id") Long id){
//        BookDTO dto;
//        return new ResponseEntity<>( dto, HttpStatus.OK);
//    }
}

