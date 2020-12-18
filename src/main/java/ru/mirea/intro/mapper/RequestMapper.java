package ru.mirea.intro.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.mirea.intro.dao.RequestDAO;
import ru.mirea.intro.service.model.Request;
import ru.mirea.intro.web.to.RequestDto;

@Mapper
public interface RequestMapper {
    RequestMapper REQUEST_MAPPER = Mappers.getMapper(RequestMapper.class);

    RequestDto requestToRequestDto(Request request);

    Request requestDTOToRequest(RequestDto requestDto);

    RequestDAO requestToRequestDAO(Request request);

    Request requestDAOToRequest(RequestDAO requestDAO);
}