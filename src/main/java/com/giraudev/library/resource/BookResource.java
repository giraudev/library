package com.giraudev.library.resource;

import com.giraudev.library.dto.BookDTO;
import com.giraudev.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/library")
public class BookResource {

    @Autowired
    BookService service;

    @PostMapping(path = "/book")
    public ResponseEntity<Void>postBook(@RequestBody BookDTO dto){
        service.post(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/book/{id}")
    public ResponseEntity<BookDTO>getBook(@PathVariable("id") Long id)throws Exception{
        BookDTO dto = service.get(id);
        return new ResponseEntity<>( dto, HttpStatus.OK);    }


    @GetMapping(path = "/book")
    public ResponseEntity <List<BookDTO>>getAllBooks() throws Exception{
        List<BookDTO> dtos = service.getAll();
        return new ResponseEntity<>( dtos, HttpStatus.OK);
   }
}

