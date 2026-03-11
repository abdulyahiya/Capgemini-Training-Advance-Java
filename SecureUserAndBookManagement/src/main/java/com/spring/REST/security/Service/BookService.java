/**
 * 
 */
package com.spring.REST.security.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.REST.security.Model.Book;
import com.spring.REST.security.Repository.BookRepository;

import lombok.Data;

/**
 * 
 */
@Data
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBook(Long id) {
        return bookRepository.findById(id).orElseThrow();
    }

    public Book updateBook(Long id, Book book) {

        Book b = getBook(id);

        b.setTitle(book.getTitle());
        b.setAuthor(book.getAuthor());
        b.setPrice(book.getPrice());
        b.setCategory(book.getCategory());

        return bookRepository.save(b);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

}