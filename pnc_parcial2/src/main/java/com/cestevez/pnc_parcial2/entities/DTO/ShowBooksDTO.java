package com.cestevez.pnc_parcial2.entities.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class ShowBooksDTO {

    private UUID id;
    private String title;
    private String author;
    private String isbn;
    private int publicationYear;
    private String genre;
    private int pages;
    private String language;
}
