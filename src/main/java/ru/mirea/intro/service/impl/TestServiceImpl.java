package ru.mirea.intro.service.impl;

import org.springframework.stereotype.Service;
import ru.mirea.intro.service.TestService;
import ru.mirea.intro.web.to.RequestDto;


@Service
public class TestServiceImpl implements TestService {

    @Override
    public RequestDto testServiceGetMethod(Long id) {
        return new RequestDto(1L, "someCustomValue");
    }

    @Override
    public String testServicePostMethod(RequestDto requestDto) {
        return "Successfully inserted!";
    }
}