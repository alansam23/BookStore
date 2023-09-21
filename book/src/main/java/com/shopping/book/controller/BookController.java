package com.shopping.book.controller;

import com.shopping.book.entities.Book;
import com.shopping.book.entities.Cart;
import com.shopping.book.exceptions.IdNotFoundException;
import com.shopping.book.repository.BookRepository;
import com.shopping.book.repository.CartRepository;
import com.shopping.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CartRepository cartRepository;

    @PostMapping("/book")
    public Book saveBooks(@RequestBody Book book) {
        return bookService.saveBooks(book);
    }

    @GetMapping("/book")
    public List<Book> fetchBookList() {
        return bookService.fetchBookList();
    }

    @GetMapping("/book/author")
    public ResponseEntity<List<Book>> findBookByName(@RequestParam String author) {
        return new ResponseEntity<List<Book>>(bookRepository.findByAuthor(author), HttpStatus.OK);
    }

    @GetMapping("/book/{id}")
    public Book fetchBookById(@PathVariable("id") Long bookId) {
        return bookService.fetchBookById(bookId);
    }


//    @PutMapping("/{bookId}/cart/{cartId}")
//    public Book assignCartToBook(
//        @PathVariable Long bookId,
//                @PathVariable Long cartId){
//        Book book = bookRepository.findById(bookId).get();
//        Cart cart = cartRepository.findById(cartId).get();
//        book.setCart(cart);
//        return bookRepository.save(book);
//    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteBookById(@PathVariable("id") Long bookId) {
        Book db = bookRepository.findById(bookId)
                .orElseThrow(() -> new IdNotFoundException("Book is not Exist with id " + bookId));
        bookRepository.delete(db);
        Map<String, Boolean> res = new HashMap<>();
        res.put("Book Deleted", Boolean.TRUE);
        return ResponseEntity.ok(res);
    }

    @PutMapping("/book/{id}")
    public Book updateBookById(@PathVariable("id") Long bookId,
                               @RequestBody Book book) {
        return bookService.updateBookById(bookId, book);
    }
}
