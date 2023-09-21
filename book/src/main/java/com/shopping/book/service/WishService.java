package com.shopping.book.service;

import com.shopping.book.entities.Wish;
import com.shopping.book.exceptions.IdNotFoundException;
import com.shopping.book.repository.WishRepository;
import com.shopping.book.service.iservice.IWishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishService implements IWishService {
    @Autowired
    private WishRepository wishRepository;

    @Override
    public Wish saveWishBook(Wish wish) {
        return wishRepository.save(wish);
    }

    @Override
    public List<Wish> getAllWishBook() {
        return wishRepository.findAll();
    }

    @Override
    public Wish getWishBookById(Long wishId) {
        return wishRepository.findById(wishId)
                .orElseThrow(() -> new IdNotFoundException("Book Is Not exist in WishList " + wishId));
    }

    @Override
    public Wish updateWishById(Long wishId, Wish wish) {
        Wish db = wishRepository.findById(wishId)
                .orElseThrow(() -> new IdNotFoundException("Book Is Not exist in WishList " + wishId));
        db.setNoOfWish(Long.valueOf(wish.getNoOfWish()));
        db.setUrl(wish.getUrl());
        return wishRepository.save(db);
    }

    @Override
    public void deleteWishById(Long wishId) {
        Wish db = wishRepository.findById(wishId)
                .orElseThrow(()->new IdNotFoundException("Id Not Found"));
        wishRepository.delete(db);
    }
}
