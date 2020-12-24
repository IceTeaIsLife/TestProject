package ru.mirea.intro.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.mirea.intro.service.model.Book;
import ru.mirea.intro.web.to.BookTO;

@Mapper
public interface BookMapper {
    BookMapper BOOK_MAPPER = Mappers.getMapper(BookMapper.class);

    Book bookTOToBook(BookTO bookTO);

    BookTO bookToBookTO(Book book);
}
