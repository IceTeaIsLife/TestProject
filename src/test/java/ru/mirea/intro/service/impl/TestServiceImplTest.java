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
        bookList.add(new Book(17L, "Толстой", "Война и мир"));
        Request request = new Request(404L, "Первый запрос", bookList);
        Assertions.assertEquals(request, testService.testServiceGetMethod(404L));
    }

    @DisplayName("Testing for normal post")
    @Test
    @Transactional
    void testServicePostMethod() {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(456L, "Толстой Тест 123", "Война и Мир Тест 123"));
        Request request = new Request(new Random().nextLong(), "Второй запрос из теста", bookList);
        Assertions.assertEquals("Successfully inserted row!", testService.testServicePostMethod(request));
    }

    @DisplayName("Testing for normal delete")
    @Test
    @Transactional
    void testServiceDeleteMethod() throws NoSuchRequest {
        Assertions.assertEquals("Removal is successful!", testService.testServiceDeleteMethod(404L));
    }

    @DisplayName("Testing for normal response of PUT-method")
    @Test
    @Transactional
    void testServicePutMethod() throws NoSuchRequest {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(17L, "Толстой", "Война и мир"));
        Request request = new Request(404L, "Первый запрос", bookList);
        Assertions.assertEquals("Database successfully updated!", testService.testServicePutMethod(request));
    }
}