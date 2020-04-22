package com.java.graphql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.java.graphql.dao.entity.Author;
import com.java.graphql.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorMutation implements GraphQLMutationResolver {

    private AuthorService authorService;

    @Autowired
    public AuthorMutation(final AuthorService authorService) {
       this.authorService = authorService ;
     }

    public Author createAuthor(final String fname, final String lname) {
       return this.authorService.createAuthor(fname,lname);
    }

    /*
    mutation {
  createAuthor(
    firstname: "ramesh",





























































             |


    lastname: "bellamkonda") {
      id firstname
  }
}
     */
}
