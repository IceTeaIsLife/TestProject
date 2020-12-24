package ru.mirea.intro.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mirea.intro.exception.NoSuchRequest;
import ru.mirea.intro.mapper.RequestMapper;
import ru.mirea.intro.service.TestService;
import ru.mirea.intro.service.model.Request;
import ru.mirea.intro.web.to.Meta;
import ru.mirea.intro.web.to.RequestDto;
import ru.mirea.intro.web.to.Response;

import java.util.Optional;

@RestController
@RequestMapping("api/mirea")
@Api(tags="Методы для тестирования приложения")
public class MireaController {
    private final TestService testService;

    public MireaController(TestService testService) {
        this.testService = testService;
    }

    @PostMapping("/post-method")
    @ApiOperation(value = "POST-метод тестового веб-сервиса",  notes = "Отправление POST-запроса")
            //"\nВходные параметры:\n - RequestDto requestDto\n - Optional<String> optionalStringValue")
    public ResponseEntity<Response<String>> postMethod(@ApiParam(value = "Тело запроса - список книг и значение типа String", required = true)
                                                           @RequestBody RequestDto requestDto,
                                                       @ApiParam(value = "Опциональный параметр", required = false)
                                                       @RequestParam Optional<String> optionalStringValue) {
        try {
            Request request = RequestMapper.REQUEST_MAPPER.requestDTOToRequest(requestDto);
            String testServiceResponse = testService.testServicePostMethod(request);
            return new ResponseEntity<>(new Response<>(new Meta(0, "All good!"), testServiceResponse), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response<>(new Meta(1, e.toString()), null), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/get-method")
    @ApiOperation(value = "GET-метод тестового веб-сервиса",  notes = "Отправление GET-запроса")
            //"\nВходные параметры:\n - Long id")
    public ResponseEntity<Response<RequestDto>> getMethod(@ApiParam(value = "Id запроса в базе данных", required = true)
                                                            @RequestParam Long id) {
        try {
            Request request = testService.testServiceGetMethod(id);
            RequestDto requestDto = RequestMapper.REQUEST_MAPPER.requestToRequestDto(request);
            return new ResponseEntity<>(new Response<>(new Meta(0, "All good!"), requestDto), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response<>(new Meta(1, e.toString()), null), HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/delete-method")
    @ApiOperation(value = "DELETE-метод тестового веб-сервиса",  notes = "Отправление DELETE-запроса")
            //"\nВходные параметры:\n - Long id")
    public ResponseEntity<Response<String>> deleteMethod(@ApiParam(value = "Id запроса в базе данных", required = true)
                                                             @RequestParam Long id)
    {
        try{
            String testServiceResponse = testService.testServiceDeleteMethod(id);
            return new ResponseEntity<>(new Response<>(new Meta(0, "All good!"), testServiceResponse), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response<>(new Meta(1, e.toString()), null), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/put-method")
    @ApiOperation(value = "PUT-метод тестового веб-сервиса",  notes = "Отправление PUT-запроса")
            //"\nВходные параметры:\n - RequestDto requestDto")
    public ResponseEntity<Response<String>> putMethod(@ApiParam(value = "Тело запроса - список книг и значение типа String", required = true)
                                                          @RequestBody RequestDto requestDto)
    {
        try{
            Request request = RequestMapper.REQUEST_MAPPER.requestDTOToRequest(requestDto);
            String testServiceResponse = testService.testServicePutMethod(request);
            return new ResponseEntity<>(new Response<>(new Meta(0, "All good!"), testServiceResponse), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(new Response<>(new Meta(1, e.toString()), null), HttpStatus.NOT_FOUND);
        }
    }

}
