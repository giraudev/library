package com.giraudev.library.worker;

import com.giraudev.library.domain.Book;
import com.giraudev.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Profile("default")
@Component
public class CrawlerConfig {

    @Autowired
    private BookRepository repository;

    @Autowired
    private CrawlerWorker crawler;

    public void run(ApplicationArguments applicationArguments) throws Exception {
        long total = repository.count();

        if (total == 0) {
            List<Book> entities  = crawler.parser();
            repository.saveAll(entities);
        }
}}
