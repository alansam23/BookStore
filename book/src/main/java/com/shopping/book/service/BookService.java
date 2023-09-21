package com.shopping.book.service;

import com.shopping.book.entities.Book;
import com.shopping.book.repository.BookRepository;
import com.shopping.book.service.iservice.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BookService implements IBookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book saveBooks(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> fetchBookList() {
        return bookRepository.findAll();
    }

    @Override
    public Book fetchBookById(Long bookId) {
        return bookRepository.findById(bookId).get();
    }

    @Override
    public Book updateBookById(Long bookId, Book book) {
        Book db= bookRepository.findById(bookId).get();

        if(Objects.nonNull(book.getBookCode()) &&
                !"".equalsIgnoreCase(book.getBookCode())){
            db.setBookCode(Long.valueOf(book.getBookCode()));
        }
        if(Objects.nonNull(book.getBookName()) &&
                !"".equalsIgnoreCase(book.getBookName())){
            db.setBookName(book.getBookName());
        }
        if(Objects.nonNull(book.getAuthor()) &&
                !"".equalsIgnoreCase(book.getAuthor())){
            db.setAuthor(book.getAuthor());
        }
        if(Objects.nonNull(book.getPages()) &&
                !"".equalsIgnoreCase(book.getPages())){
            db.setPages(Long.valueOf(book.getPages()));
        }

        return bookRepository.save(db);
    }
}
