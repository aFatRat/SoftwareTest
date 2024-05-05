package com.example.softwaretest.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.example.softwaretest.DAO.BookDAO;
import com.example.softwaretest.constant.Constant;
import com.example.softwaretest.entity.Book;
import com.example.softwaretest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookDAO bookDAO;

    @Override
    public Book getBook(int bookId) {
        return bookDAO.findBookByBookId(bookId);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDAO.findAll();
    }

    @Override
    public String addBook(Map<String, String> params) {
        String message;
        String name=params.get("name");
        String description= params.get("description");
        String avatar=params.get("avatar");
        String price=params.get("price");
        String date=params.get("date");
        String author=params.get("author");
        Book tmp=bookDAO.findBookByNameAndAuthor(name,author);
        if(tmp!=null){
            message="fail";
            return JSON.toJSONString(message);
        }
        Book book=new Book();
        book.setAuthor(author);
        book.setName(name);
        book.setAvatar(avatar);
        book.setPrice(new BigDecimal(price));
        book.setDescription(description);
        book.setDate(java.sql.Date.valueOf(date));
        bookDAO.addBook(book);
        message="success";
        return JSON.toJSONString(message);
    }

    @Override
    public String updateBook(Map<String, String> params) throws ParseException {
        String name=params.get("name");
        String description= params.get("description");
        String avatar=params.get("avatar");
        String price=params.get("price");
        String date=params.get("date");
        String author=params.get("author");
        Book tmp=bookDAO.findBookByNameAndAuthor(name,author);
        if (tmp==null)
            return JSON.toJSONString("fail");
        tmp.setDate(java.sql.Date.valueOf(date));
        tmp.setDescription(description);
        tmp.setAvatar(avatar);
        tmp.setPrice(new BigDecimal(price));
        bookDAO.addBook(tmp);
        return JSON.toJSONString("success");
    }

    @Override
    public String removeBook(Book book) {
        bookDAO.removeBook(book);
        return JSON.toJSONString("success");
    }


}
