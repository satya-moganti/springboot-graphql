package com.java.graphql.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    public Book(int id, String name, String description, int pagecount, String publisher, String publishedyear, Author author) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.pagecount = pagecount;
        this.publisher = publisher;
        this.publishedyear = publishedyear;
        this.author = author;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String name;
    @Column
    private String description;

    @Column
    private int pagecount;

    @Column
    private String publisher;

    @Column
    private String publishedyear;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false, updatable = false)
    private Author author;
}

