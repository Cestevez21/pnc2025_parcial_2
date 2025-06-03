package com.cestevez.pnc_parcial2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "isbn", nullable = false, unique = true, length = 13)
    private String isbn;

    @Column(name = "publicationYear", nullable = false)
    private Integer publicationYear;

    @Column(name = "language", nullable = true)
    private String language;

    @Column(name = "pages", nullable = false)
    private Integer pages;

    @Column(name = "genre", nullable = false)
    private String genre;

}
