package ru.mirea.intro.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.intro.dao.BookDao;

@Repository
public interface BookRepository extends JpaRepository<BookDao, Long> {
}
