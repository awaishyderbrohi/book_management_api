package com.example.book_management.service;

import com.example.book_management.repo.BookRepository;
import com.example.book_management.entity.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks(int page, int limit, String genre, String author) {
        Pageable pageable = PageRequest.of(page - 1, limit);
        if (genre != null) {
            return bookRepository.findByGenre(genre);
        } else if (author != null) {
            return bookRepository.findByAuthor(author);
        }
        return bookRepository.findAll(pageable).getContent();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book bookDetails) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setDescription(bookDetails.getDescription());
        book.setIsbn(bookDetails.getIsbn());
        book.setPublishedDate(bookDetails.getPublishedDate());
        book.setGenre(bookDetails.getGenre());
        book.setPublisher(bookDetails.getPublisher());
        book.setLanguage(bookDetails.getLanguage());
        book.setPageCount(bookDetails.getPageCount());
        book.setCoverImageUrl(bookDetails.getCoverImageUrl());
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}