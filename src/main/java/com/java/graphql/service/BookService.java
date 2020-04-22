package com.java.graphql.service;

import com.java.graphql.dao.entity.Author;
import com.java.graphql.dao.entity.Book;
import com.java.graphql.dao.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {
    
    private BookRepository bookRepository;
    @Autowired
    public BookService(final BookRepository bookRepository) {
        this.bookRepository = bookRepository ;
    }

    @Transactional
    public Book createBook(final String name,String description, final int pagecount, final String publisher,final String publishedyear,Integer authorId) {
       final Book book = new Book();
        book.setAuthor(new Author(authorId));
        book.setName(name);
        book.setDescription(description);
        book.setPagecount(pagecount);
        book.setPublisher(publisher);
        book.setPublishedyear(publishedyear);
        return this.bookRepository.save(book);
    }

    @Transactional(readOnly = true)
    public List<Book> getAllBooks(final int count) {
        return this.bookRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<Book> getBookById(final int id) {
        return this.bookRepository.findById(id);
    }
}
