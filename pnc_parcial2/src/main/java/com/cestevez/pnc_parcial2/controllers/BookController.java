package com.cestevez.pnc_parcial2.controllers;

import com.cestevez.pnc_parcial2.entities.DTO.*;
import com.cestevez.pnc_parcial2.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;


    @PostMapping("/book")
    public ResponseEntity<Void> createBook(@RequestBody @Valid SaveBookDTO info){
        try {
            bookService.createBook(info);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/books")
    public ResponseEntity<List<ShowBooksDTO>> getAllBooks(){
        try {
            List<ShowBooksDTO> books = bookService.getAllBooks();
            return ResponseEntity.ok(books);
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/book")
    public ResponseEntity<ShowBooksDTO> getBookById(@RequestBody @Valid getBookDTO info){
        try {
            ShowBooksDTO book = bookService.getBookById(info);
            return ResponseEntity.ok(book);
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/book/delete" )
    public ResponseEntity<Void> deleteBook(@RequestBody @Valid getBookDTO info){
        try {
            bookService.deleteBook(info.getId());
            return ResponseEntity.ok().build();
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/book/update")
    public ResponseEntity<Void> updateBook(@RequestBody UpdateBookDTO info){
        try {
            bookService.updateBook(info);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/book/{isbn}")
    public ResponseEntity<ShowBooksDTO> findBookByISBN(@PathVariable("isbn") String isbn){
        try {
            ShowBooksDTO book = bookService.findBookByISBN(isbn);
            return ResponseEntity.ok(book);
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/books/author/{author}")
    public ResponseEntity<List<ShowBooksDTO>> getAllBooksByAuthor(@PathVariable("author") String author){
        try {
            List<ShowBooksDTO> books = bookService.findBooksByAuthor(author);
            return ResponseEntity.ok(books);
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/books/genre/{genre}")
    public ResponseEntity<List<ShowBooksDTO>> getAllBooksByGenre(@PathVariable("genre") String genre){
        try {
            List<ShowBooksDTO> books = bookService.findBooksByGenre(genre);
            return ResponseEntity.ok(books);
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/books/language/{language}")
    public ResponseEntity<List<ShowBooksDTO>> getAllBooksByLanguage(@PathVariable("language") String language){
        try {
            List<ShowBooksDTO> books = bookService.findBookByLanguage(language);
            return ResponseEntity.ok(books);
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/book/pages/")
    public ResponseEntity<List<ShowBooksDTO>> getAllBooksByPagesBetween(@RequestBody @Valid BooksByPagesDTO info){
        try {
            List<ShowBooksDTO> books = bookService.findBooksByPagesBetween(info);
            return ResponseEntity.ok(books);
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
