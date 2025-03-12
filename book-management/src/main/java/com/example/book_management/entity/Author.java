package com.example.book_management.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Book> books;
}
