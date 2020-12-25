package ru.mirea.intro.service;

import ru.mirea.intro.exception.NoSuchRequest;
import ru.mirea.intro.service.model.Request;
import ru.mirea.intro.web.to.RequestDto;

public interface TestService {
    Request testServiceGetMethod(Long id) throws NoSuchRequest;

    Request testServicePostMethod(Request request);

    String testServiceDeleteMethod(Long id) throws NoSuchRequest;

    Request testServicePutMethod(Request request) throws NoSuchRequest;
}