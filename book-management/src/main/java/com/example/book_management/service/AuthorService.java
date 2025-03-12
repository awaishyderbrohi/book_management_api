package com.example.book_management.service;


import com.example.book_management.entity.Author;

import java.util.List;

public interface AuthorService {

    public Author save();
    public List<Author> getAllAuthors();
    public Author getAuthorById(Long id);


}
