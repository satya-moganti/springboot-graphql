package com.java.graphql.service;

import com.java.graphql.dao.entity.Author;
import com.java.graphql.dao.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(final AuthorRepository authorRepository) {
        this.authorRepository = authorRepository ;
    }

    @Transactional
    public Author createAuthor(final String fname, final String lname){
        final Author author = new Author();
        author.setFname(fname);
        author.setLname(lname);

        return this.authorRepository.save(author);
    }

    @Transactional(readOnly = true)
    public List<Author> getAllAuthors(final int count) {
        return this.authorRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<Author> getAuthorById(final int id) {
        return this.authorRepository.findById(id);
    }
}
