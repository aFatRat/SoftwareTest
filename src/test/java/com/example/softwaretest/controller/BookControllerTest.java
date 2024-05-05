package com.example.softwaretest.controller;

import com.example.softwaretest.entity.Book;
import com.example.softwaretest.service.BookService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

//@ExtendWith(SpringExtension.class)
@SpringBootTest
//@AutoConfigureMockMvc
class BookControllerTest {

//    @Autowired
//    private MockMvc mockMvc;
//    @BeforeEach
//    void setUp() {
//    }
//
//    @AfterEach
//    void tearDown() {
//    }
//
//    @Test
//    void getAllBooks() throws Exception {
//        mockMvc.perform(post("/getAllBooks")
//                .contentType("application/json"));
//    }
//
//    @Test
//    void getBook() throws Exception {
//        mockMvc.perform(post("/getBook")
//                .contentType("application/json")
//                .param("bookId","1"));
//    }
    @InjectMocks
    private BookController bookController;

    @Mock
    private BookService bookService;

//    @BeforeEach
//    public void init() {
//        MockitoAnnotations.initMocks(this);
//    }

    @Test
    public void testGetAllBooks() {
        // 模拟一个书籍列表
        List<Book> mockBooks = Arrays.asList(new Book(), new Book());

        // 当调用 bookService.getAllBooks() 时返回模拟的书籍列表
        when(bookService.getAllBooks()).thenReturn(mockBooks);

        // 调用 getAllBooks() 方法
        List<Book> result = bookController.getAllBooks();

        // 断言返回的书籍列表不为空
        assertNotNull(result);
        // 断言返回的书籍列表与模拟的书籍列表相同
        assertEquals(mockBooks, result);
    }

    @Test
    public void testGetBook() {
        // 模拟一个书籍对象
        Book mockBook = new Book();
        mockBook.setId(1); // 设置一个已知的书籍 ID

        // 当调用 bookService.getBook() 时返回模拟的书籍对象
        when(bookService.getBook(1)).thenReturn(mockBook);

        // 调用 getBook() 方法
        Book result = bookController.getBook(1);

        // 断言返回的书籍对象不为空
        assertNotNull(result);
        // 断言返回的书籍对象与模拟的书籍对象相同
        assertEquals(mockBook, result);
    }

    @Test
    public void testAddBook() throws ParseException {
        // 模拟一个添加书籍的参数
        Map<String, String> params = Map.of("title", "Test Book", "author", "Test Author");

        // 模拟添加书籍的返回结果
        String expectedResult = "Book added successfully";

        // 当调用 bookService.addBook() 时返回模拟的结果
        when(bookService.addBook(params)).thenReturn(expectedResult);

        // 调用 addBook() 方法
        String result = bookController.addBook(params);

        // 断言返回的结果与模拟的结果相同
        assertEquals(expectedResult, result);
    }

    @Test
    public void testUpdateBook() throws ParseException {
        // 模拟一个更新书籍的参数
        Map<String, String> params = Map.of("id", "1", "title", "Updated Title", "author", "Updated Author");

        // 模拟更新书籍的返回结果
        String expectedResult = "Book updated successfully";

        // 当调用 bookService.updateBook() 时返回模拟的结果
        when(bookService.updateBook(params)).thenReturn(expectedResult);

        // 调用 updateBook() 方法
        String result = bookController.updateBook(params);

        // 断言返回的结果与模拟的结果相同
        assertEquals(expectedResult, result);
    }
}