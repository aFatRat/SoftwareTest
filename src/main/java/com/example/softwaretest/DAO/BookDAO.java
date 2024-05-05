package com.example.softwaretest.DAO;

import com.example.softwaretest.entity.Book;

import java.util.List;

public interface BookDAO {
    Book findBookByBookId(int bookId);
    List<Book> findAll();
    void addBook(Book book);
    Book findBookByNameAndAuthor(String name,String author);
    void removeBook(Book book);
}
