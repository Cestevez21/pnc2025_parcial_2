package com.cestevez.pnc_parcial2.services;

import com.cestevez.pnc_parcial2.entities.Book;
import com.cestevez.pnc_parcial2.entities.DTO.*;
import com.cestevez.pnc_parcial2.repositories.BookRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@NoArgsConstructor
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public void createBook(SaveBookDTO bookInf) {
        Book book = new Book();
        book.setTitle(bookInf.getTitle());
        book.setAuthor(bookInf.getAuthor());
        book.setIsbn(bookInf.getIsbn());
        book.setPublicationYear(bookInf.getPublicationYear());
        book.setLanguage(bookInf.getLanguage());
        book.setPages(bookInf.getPages());
        book.setGenre(bookInf.getGenre());
        bookRepository.save(book);
    }

    public void deleteBook(UUID id) {
        bookRepository.deleteById(id);
    }
    public ShowBooksDTO getBookById(getBookDTO info){
        Book book = bookRepository.findById(info.getId()).get();
        return new ShowBooksDTO(book.getId(), book.getTitle(), book.getAuthor(), book.getIsbn(), book.getPublicationYear(), book.getGenre(), book.getPages(), book.getLanguage());
    }

    public List<ShowBooksDTO> getAllBooks(){
        List<ShowBooksDTO> books = new ArrayList<>();
        bookRepository.findAll().forEach(book -> {
            books.add(new ShowBooksDTO(book.getId(), book.getTitle(), book.getAuthor(), book.getIsbn(), book.getPublicationYear(), book.getGenre(), book.getPages(), book.getLanguage()));
        });
        return books;
    }
    public ShowBooksDTO findBookByISBN(String isbn){
        Book book = bookRepository.findByIsbn(isbn);
        return new ShowBooksDTO(book.getId(), book.getTitle(), book.getAuthor(), book.getIsbn(), book.getPublicationYear(), book.getGenre(), book.getPages(), book.getLanguage());
    }

    public void updateBook(UpdateBookDTO bookInf) {
        Book book = bookRepository.findById(bookInf.getId()).get();
        book.setTitle(bookInf.getTitle());
        book.setLanguage(bookInf.getLanguage());
        bookRepository.save(book);
    }

    public List<ShowBooksDTO> findBooksByAuthor(String author){
        List<ShowBooksDTO> response = new ArrayList<>();
        List<Book> books = bookRepository.findAllByAuthor(author);

        books.forEach(book -> {
            response.add(new ShowBooksDTO(book.getId(), book.getTitle(), book.getAuthor(), book.getIsbn(), book.getPublicationYear(), book.getGenre(), book.getPages(), book.getLanguage()));
        });

        return response;
    }

    public List<ShowBooksDTO> findBooksByPagesBetween(BooksByPagesDTO info){
        List<ShowBooksDTO> response = new ArrayList<>();
        List<Book> books = bookRepository.findAllByPagesBetween(info.getMin(), info.getMax());

        books.forEach(book -> {
            response.add(new ShowBooksDTO(book.getId(), book.getTitle(), book.getAuthor(), book.getIsbn(), book.getPublicationYear(), book.getGenre(), book.getPages(), book.getLanguage()));
        });

        return response;
    }

    public List<ShowBooksDTO> findBookByLanguage(String language){
        List<ShowBooksDTO> response = new ArrayList<>();
        List<Book> books = bookRepository.findAllByLanguage(language);

        books.forEach(book -> {
            response.add(new ShowBooksDTO(book.getId(), book.getTitle(), book.getAuthor(), book.getIsbn(), book.getPublicationYear(), book.getGenre(), book.getPages(), book.getLanguage()));
        });

        return response;
    }


    public List<ShowBooksDTO> findBooksByGenre(String genre){
        List<ShowBooksDTO> response = new ArrayList<>();
        List<Book> books = bookRepository.findAllByGenre(genre);

        books.forEach(book -> {
            response.add(new ShowBooksDTO(book.getId(), book.getTitle(), book.getAuthor(), book.getIsbn(), book.getPublicationYear(), book.getGenre(), book.getPages(), book.getLanguage()));
        });

        return response;
    }
}
