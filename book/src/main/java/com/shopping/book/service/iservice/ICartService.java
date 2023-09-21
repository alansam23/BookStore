package com.shopping.book.service.iservice;

import com.shopping.book.entities.Book;
import com.shopping.book.entities.Cart;

import java.util.List;

public interface ICartService {
    Cart saveCart(Cart cart);

    List<Cart> fetchCartList();

    Cart fetchCartById(Long cartId);

    void deleteCartById(Long cartId);

    Cart updateCartById(Long cartId, Cart cart);
}
