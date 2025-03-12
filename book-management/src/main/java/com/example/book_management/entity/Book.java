package com.example.book_management.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private String isbn;
    private LocalDate publishedDate;
    @CreationTimestamp
    private LocalDate addedAt;
    private LocalDate UpdatedAt;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Author author;

}
