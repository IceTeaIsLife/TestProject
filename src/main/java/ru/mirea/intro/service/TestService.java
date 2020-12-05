package ru.mirea.intro.service;


import ru.mirea.intro.web.to.RequestDto;

public interface TestService {
    RequestDto testServiceGetMethod(Long id);

    String testServicePostMethod(RequestDto requestDto);
}