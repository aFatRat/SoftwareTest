package com.example.softwaretest.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.example.softwaretest.DAO.BookDAO;
import com.example.softwaretest.entity.Book;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class BookServiceImplTest {

    @InjectMocks
    private BookServiceImpl bookService;

    @Mock
    private BookDAO bookDAO;
    @Test
    public void testGetBook() {
        // 模拟一个书籍对象
        Book mockBook = new Book();
        mockBook.setId(1); // 设置一个已知的书籍 ID

        // 当调用 bookDAO.findBookByBookId() 时返回模拟的书籍对象
        when(bookDAO.findBookByBookId(1)).thenReturn(mockBook);

        // 调用 getBook() 方法
        Book result = bookService.getBook(1);

        // 断言返回的书籍对象不为空
        assertNotNull(result);
        // 断言返回的书籍对象与模拟的书籍对象相同
        assertEquals(mockBook, result);
    }

    @Test
    public void testGetAllBooks() {
        // 模拟一个书籍列表
        List<Book> mockBooks = Arrays.asList(new Book(), new Book());

        // 当调用 bookDAO.findAll() 时返回模拟的书籍列表
        when(bookDAO.findAll()).thenReturn(mockBooks);

        // 调用 getAllBooks() 方法
        List<Book> result = bookService.getAllBooks();

        // 断言返回的书籍列表不为空
        assertNotNull(result);
        // 断言返回的书籍列表与模拟的书籍列表相同
        assertEquals(mockBooks, result);
    }

    @Test
    public void testAddBook() throws ParseException {
        // 模拟添加书籍的参数
        Map<String, String> params = new HashMap<>();
        params.put("name", "Test Book");
        params.put("description", "Test Description");
        params.put("avatar", "Test Avatar");
        params.put("price", "10.99");
        params.put("date", "2024-05-05");
        params.put("author", "Test Author");

        // 模拟添加书籍后返回的消息
        String expectedResult = JSON.toJSONString("success");

        // 当调用 bookDAO.findBookByNameAndAuthor() 时返回 null，表示该书籍不存在
        when(bookDAO.findBookByNameAndAuthor("Test Book", "Test Author")).thenReturn(null);

        // 调用 addBook() 方法
        String result = bookService.addBook(params);

        // 断言返回的结果与模拟的结果相同
        assertEquals(expectedResult, result);

        // add
        String expectedFailResult = JSON.toJSONString("fail");
        Book book=new Book();
        when(bookDAO.findBookByNameAndAuthor("Test Book", "Test Author")).thenReturn(book);
        String resultFail = bookService.addBook(params);
        assertEquals(expectedFailResult, resultFail);
    }

    @Test
    public void testUpdateBook() throws ParseException {
        // 模拟更新书籍的参数
        Map<String, String> params = new HashMap<>();
        params.put("name", "Updated Test Book");
        params.put("description", "Updated Test Description");
        params.put("avatar", "Updated Test Avatar");
        params.put("price", "20.99");
        params.put("date", "2024-05-05");
        params.put("author", "Updated Test Author");

        String expectedResultFail = JSON.toJSONString("fail");
        when(bookDAO.findBookByNameAndAuthor("Updated Test Book", "Updated Test Author")).thenReturn(null);
        String resultFail = bookService.updateBook(params);
        assertEquals(expectedResultFail, resultFail);
        // 模拟更新书籍后返回的消息
        String expectedResult = JSON.toJSONString("success");

        // 模拟一个存在的书籍对象
        Book mockBook = new Book();

        // 当调用 bookDAO.findBookByNameAndAuthor() 时返回模拟的书籍对象
        when(bookDAO.findBookByNameAndAuthor("Updated Test Book", "Updated Test Author")).thenReturn(mockBook);

        // 调用 updateBook() 方法
        String result = bookService.updateBook(params);

        // 断言返回的结果与模拟的结果相同
        assertEquals(expectedResult, result);
    }

    @Test
    public void testRemoveBook() {
        // 模拟一个要移除的书籍对象
        Book bookToRemove = new Book();
        bookToRemove.setId(1); // 设置一个已知的书籍 ID

        // 调用 removeBook() 方法
        String result = bookService.removeBook(bookToRemove);

        // 断言返回的结果为 "success"
        assertEquals(JSON.toJSONString("success"), result);
    }
}