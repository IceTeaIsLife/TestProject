package ru.mirea.intro.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.intro.dao.BookDao;
import ru.mirea.intro.dao.RequestDAO;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookDao, Long> {
    List<BookDao> findByRequestDaoOrderByIdDesc(RequestDAO requestDAO);
}
