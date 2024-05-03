package com.example.softwaretest.controller;


import com.example.softwaretest.entity.Book;
import com.example.softwaretest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @RequestMapping("/getAllBooks")
    @CrossOrigin
    public List<Book> getAllBooks(){
        ArrayList<Book> books;
        List<Book> result;
        result=bookRepository.findAll();
        return result;
    }

    @RequestMapping("/getBook")
    @CrossOrigin
    public Optional<Book> getBook(@RequestParam Integer bookId){
        Optional<Book> result;
        result=bookRepository.findById(bookId);
        return result;
    }
}
