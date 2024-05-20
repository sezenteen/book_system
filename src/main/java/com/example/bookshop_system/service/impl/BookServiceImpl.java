package com.example.bookshop_system.service.impl;

import com.example.bookshop_system.repository.BookRepository;
import com.example.bookshop_system.service.BookService;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    private static final String TEXT_FILE = "src/main/resources/files/books.txt";


    @Override
    public void seedBooks() throws IOException {

    }
}
