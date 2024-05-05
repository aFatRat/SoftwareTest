package com.example.softwaretest.service;

import com.example.softwaretest.entity.Book;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface BookService {
    Book getBook(int bookId);
    List<Book> getAllBooks();
    String addBook(Map<String,String> params) throws ParseException;
    String updateBook(Map<String,String> params) throws ParseException;
    String removeBook(Book book);
}
