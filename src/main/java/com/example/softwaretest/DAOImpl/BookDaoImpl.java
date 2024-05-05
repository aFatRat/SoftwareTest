package com.example.softwaretest.DAOImpl;

import com.example.softwaretest.DAO.BookDAO;
import com.example.softwaretest.entity.Book;
import com.example.softwaretest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookDaoImpl implements BookDAO {
    @Autowired
    BookRepository bookRepository;

    @Override
    public Book findBookByBookId(int bookId) {
        Optional<Book> book=bookRepository.findById(bookId);
        return book.orElse(null);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book findBookByNameAndAuthor(String name, String author) {
        return bookRepository.findFirstByNameAndAuthor(name,author).orElse(null);
    }

    @Override
    public void removeBook(Book book) {
        bookRepository.delete(book);
    }
}
