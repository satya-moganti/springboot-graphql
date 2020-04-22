package com.java.graphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.java.graphql.dao.entity.Book;
import com.java.graphql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookQuery implements GraphQLQueryResolver {

    private BookService bookService;
	@Autowired
    public BookQuery(final BookService bookService) {
        this.bookService = bookService ;
    }


    public List<Book> getBooks(final int count) {
        return this.bookService.getAllBooks(count);
    }

    public Optional<Book> bookById(final int id) {
        return this.bookService.getBookById(id);
    }
}
