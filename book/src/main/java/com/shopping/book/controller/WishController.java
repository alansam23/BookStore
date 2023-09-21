package com.shopping.book.controller;

import com.shopping.book.entities.Wish;
import com.shopping.book.exceptions.IdNotFoundException;
import com.shopping.book.service.WishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WishController {
    @Autowired
    private WishService wishService;

    @PostMapping("/wish")
    public Wish saveWishBook(@RequestBody Wish wish){
        return wishService.saveWishBook(wish);
    }

    @GetMapping("/wish")
    public List<Wish> getAllWishBook(){
        return wishService.getAllWishBook();
    }

    @GetMapping("/wish/{id}")
    public Wish getWishBookById(@PathVariable ("id") Long wishId){
        return wishService.getWishBookById(wishId);
    }
    @PutMapping("/wish/{id}")
    public Wish updateWishById(@PathVariable ("id")Long wishId,
                               Wish wish){
        return wishService.updateWishById(wishId,wish);
    }

    @DeleteMapping("/wish/{id}")
    public String deleteWishById(@PathVariable ("id") Long wishId){
        wishService.deleteWishById(wishId);
        return "Selected Book Wish Deleted Successfully";
    }
}
