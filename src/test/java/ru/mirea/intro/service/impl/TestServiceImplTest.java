package ru.mirea.intro.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.mirea.intro.exception.NoSuchRequest;
import ru.mirea.intro.service.TestService;
import ru.mirea.intro.service.model.Book;
import ru.mirea.intro.service.model.Request;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
class TestServiceImplTest {
    @Autowired
    TestService testService;

    @DisplayName("Testing for NoSuchRequest")
    @Test
    void testServiceGetMethodException() {
        Assertions.assertThrows(NoSuchRequest.class, () -> testService.testServiceGetMethod(1234L)
        );
    }

    @DisplayName("Testing for normal response")
    @Test
    @Transactional
    void testServiceGetMethod() throws NoSuchRequest {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(3L, "2 book", "string"));
        bookList.add(new Book(2L, "1 book", "string"));
        Request request = new Request(52L, "test", bookList);
        Assertions.assertEquals(request, testService.testServiceGetMethod(52L));
    }

    @DisplayName("Testing for normal post")
    @Test
    @Transactional
    void testServicePostMethod() {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(3L, "2 book", "string"));
        bookList.add(new Book(2L, "1 book", "string"));
        Request request = new Request(52L, "test", bookList);
        Assertions.assertEquals(request, testService.testServicePostMethod(request));
    }

    @DisplayName("Testing for NoSuchRequest for DELETE-method")
    @Test
    void testServiceDeleteMethodException() {
        Assertions.assertThrows(NoSuchRequest.class, () -> testService.testServiceDeleteMethod(1234L)
        );
    }

    @DisplayName("Testing for normal delete")
    @Test
    @Transactional
    void testServiceDeleteMethod() throws NoSuchRequest {
        Assertions.assertEquals("Removal is successful!", testService.testServiceDeleteMethod(202L));
    }

    @DisplayName("Testing for NoSuchRequest for PUT-method")
    @Test
    void testServicePutMethodException() {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(25L, "Толстой", "Война и мир"));
        Request request = new Request(404L, "Первый запрос", bookList);
        Assertions.assertThrows(NoSuchRequest.class, () -> testService.testServicePutMethod(request));
    }

    @DisplayName("Testing for normal response of PUT-method")
    @Test
    @Transactional
    void testServicePutMethod() throws NoSuchRequest {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(3L, "2 book", "string"));
        bookList.add(new Book(2L, "1 book", "string"));
        Request request = new Request(52L, "test", bookList);
        Assertions.assertEquals(request, testService.testServicePutMethod(request));
    }
}