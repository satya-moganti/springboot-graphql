package com.java.graphql.resolver;

import com.java.graphql.dao.entity.Author;
import com.java.graphql.dao.entity.Book;
import com.java.graphql.dao.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.coxautodev.graphql.tools.GraphQLResolver;

@Component
public class BookResolver implements GraphQLResolver<Book> {
  @Autowired
  private AuthorRepository authorRepository;

  public BookResolver(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  public Author getAuthor(Book book) {
    return authorRepository.findById(book.getAuthor().getId()).orElseThrow(null);
  }
}