package com.example.softwaretest.controller;

import com.example.softwaretest.entity.Book;
import com.example.softwaretest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @RequestMapping("/getAllBooks")
    @CrossOrigin
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @RequestMapping("/getBook")
    @CrossOrigin
    public Book getBook(@RequestParam Integer bookId){
        return bookService.getBook(bookId);
    }

    @RequestMapping("/addBook")
    @CrossOrigin
    public String addBook(@RequestBody Map<String,String> params) throws ParseException {
        return bookService.addBook(params);
    }

    @RequestMapping("/updateBook")
    @CrossOrigin
    public String updateBook(@RequestBody Map<String,String> params) throws ParseException {
        return bookService.updateBook(params);
    }

//    @RequestMapping("/removeBook")
//    @CrossOrigin
//    public String removeBook(@RequestBody Book book){
//        return bookService.removeBook(book);
//    }
}
