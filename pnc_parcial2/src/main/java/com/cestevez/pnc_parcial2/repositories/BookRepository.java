package com.cestevez.pnc_parcial2.repositories;

import com.cestevez.pnc_parcial2.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {

    public List<Book> findAllByAuthor(String author);
    public List<Book> findAllByLanguage(String language);
    public Book findByIsbn(String isbn);
    public List<Book> findAllByGenre(String genre);
    public List<Book> findAllByPagesBetween(int min, int max);
}
