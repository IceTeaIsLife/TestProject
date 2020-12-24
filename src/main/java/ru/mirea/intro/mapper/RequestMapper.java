package ru.mirea.intro.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import ru.mirea.intro.dao.RequestDAO;
import ru.mirea.intro.service.model.Request;
import ru.mirea.intro.web.to.RequestDto;

@Mapper(uses = BookMapper.class)
public interface RequestMapper {
    RequestMapper REQUEST_MAPPER = Mappers.getMapper(RequestMapper.class);

    @Mappings({
            @Mapping(target = "bookTOList", source = "request.bookList")})
    RequestDto requestToRequestDto(Request request);

    @Mappings({
            @Mapping(target = "bookList", source = "requestDto.bookTOList")})
    Request requestDTOToRequest(RequestDto requestDto);

    @Mappings({
            @Mapping(target = "bookDaoList", source = "request.bookList")})
    RequestDAO requestToRequestDAO(Request request);

    @Mappings({
            @Mapping(target = "bookList", source = "requestDAO.bookDaoList")})
    Request requestDAOToRequest(RequestDAO requestDAO);
}