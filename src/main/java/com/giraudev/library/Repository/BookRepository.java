package com.giraudev.library.Repository;

import com.giraudev.library.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findById(Long id);
    Optional<Book> findByIsbn(String isbn);

}
