package com.shopping.book.service.iservice;

import com.shopping.book.entities.Wish;

import java.util.List;

public interface IWishService {
    Wish saveWishBook(Wish wish);

    List<Wish> getAllWishBook();

    Wish getWishBookById(Long wishId);

    Wish updateWishById(Long wishId, Wish wish);

    void deleteWishById(Long wishId);
}
