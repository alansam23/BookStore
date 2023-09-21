package com.shopping.book.controller;

import com.shopping.book.entities.Book;
import com.shopping.book.entities.Cart;
import com.shopping.book.repository.BookRepository;
import com.shopping.book.repository.CartRepository;
import com.shopping.book.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private BookRepository bookRepository;
    @PostMapping("/cart&book")
    public ResponseEntity<String> saveOrderAndCartDetails(@RequestBody List<Cart> carts){
        cartRepository.saveAll(carts);
        return ResponseEntity.ok("Cart & Order Details Saved");
    }
    @PostMapping("/cart")
    public Cart saveCart(@RequestBody Cart cart) {
        return cartService.saveCart(cart);
    }

    @GetMapping("/cart")
    public List<Cart> fetchCartList() {
        return cartService.fetchCartList();
    }

    @GetMapping("/cart/{id}")
    public Cart fetchCartById(@PathVariable("id") Long cartId) {
        return cartService.fetchCartById(cartId);
    }

    @DeleteMapping("/cart/{id}")
    public String deleteCartById(@PathVariable("id") Long cartId) {
        cartService.deleteCartById(cartId);
        return "Cart Deleted Successfully";
    }

    @PutMapping("/cart/{id}")
    public Cart updateOrderById(@PathVariable("id") Long cartId,
                                 @RequestBody Cart cart) {
        return cartService.updateCartById(cartId, cart);
    }
    @PutMapping("/{cartId}/book/{bookId}")
    public Cart assignBooks(
            @PathVariable Long cartId,
            @PathVariable Long bookId
    ){
        Cart cart = cartRepository.findById(cartId).get();
        Book book = bookRepository.findById(bookId).get();
        cart.assignBooks(book);
        return cartRepository.save(cart);
    }
}
