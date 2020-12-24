package ru.mirea.intro.service;

import ru.mirea.intro.exception.NoSuchRequest;
import ru.mirea.intro.service.model.Request;
import ru.mirea.intro.web.to.RequestDto;

public interface TestService {
    Request testServiceGetMethod(Long id) throws NoSuchRequest;

    String testServicePostMethod(Request request);

    String testServiceDeleteMethod(Long id) throws NoSuchRequest;

    String testServicePutMethod(Request request) throws NoSuchRequest;
}