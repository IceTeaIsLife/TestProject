package ru.mirea.intro.service;

import ru.mirea.intro.exception.NoSuchRequest;
import ru.mirea.intro.service.model.Request;

public interface TestService {
    Request testServiceGetMethod(Long id) throws NoSuchRequest;

    String testServicePostMethod(Request request);
}