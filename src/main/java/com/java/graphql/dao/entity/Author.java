package com.java.graphql.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Author implements Serializable {
    private static final long serialVersionUID = 1L;

    public Author(Integer id) {
        this.id = id;
    }

    public Author(Integer id,String fname, String lname) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="fname",nullable = false)
    private String fname;

    @Column(name="lname")
    private String lname;


}
