package com.shopping.book.service.iservice;

import com.shopping.book.entities.Book;

import java.util.List;

public interface IBookService {
    public Book saveBooks(Book book) ;

    public List<Book> fetchBookList();

    public Book fetchBookById(Long bookId);

    public Book updateBookById(Long bookId, Book book);

}
