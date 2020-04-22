package com.java.graphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.java.graphql.dao.entity.Author;
import com.java.graphql.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AuthorQuery implements GraphQLQueryResolver {
     
	 private AuthorService authorService;

    @Autowired
    public AuthorQuery(final AuthorService authorService) {
       this.authorService = authorService ;
     }

    public List<Author> getAuthors(final int count) {
        return this.authorService.getAllAuthors(count);
    }

    public Optional<Author> authorById(final int id) {
        return this.authorService.getAuthorById(id);
    }
}
