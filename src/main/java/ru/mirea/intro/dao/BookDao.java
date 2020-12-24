package ru.mirea.intro.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Book", schema = "public")
public class BookDao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String author;
    private String name;
    @ManyToOne
    @JoinColumn(name = "request_id", nullable = false)
    private RequestDAO requestDao;
}
