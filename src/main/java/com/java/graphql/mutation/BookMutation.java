package com.java.graphql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.java.graphql.dao.entity.Author;
import com.java.graphql.dao.entity.Book;
import com.java.graphql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookMutation implements GraphQLMutationResolver {

     private BookService bookService;
	 @Autowired
    public BookMutation(final BookService bookService) {
        this.bookService = bookService ;
    }

    public Book createBook(final String name,final String description, final int pagecount,final String publisher, final String publishedyear,Integer id) {
        return this.bookService.createBook(name, description,pagecount, publisher,publishedyear,id);
    }
}
