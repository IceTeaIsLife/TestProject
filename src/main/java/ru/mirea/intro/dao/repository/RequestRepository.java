package ru.mirea.intro.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.intro.dao.RequestDAO;

@Repository
public interface RequestRepository extends JpaRepository<RequestDAO, Long> {
}