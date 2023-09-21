package com.shopping.book.service;

import com.shopping.book.entities.Book;
import com.shopping.book.entities.Cart;
import com.shopping.book.repository.CartRepository;
import com.shopping.book.service.iservice.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CartService implements ICartService {
    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public List<Cart> fetchCartList() {
        return cartRepository.findAll();
    }

    @Override
    public Cart fetchCartById(Long cartId) {
        return cartRepository.findById(cartId).get();
    }

    @Override
    public void deleteCartById(Long cartId) {
        cartRepository.deleteById(cartId);
    }

    @Override
    public Cart updateCartById(Long cartId, Cart cart) {
        Cart db= cartRepository.findById(cartId).get();

        if(Objects.nonNull(cart.getNoOfItems()) &&
                !"".equalsIgnoreCase(cart.getNoOfItems())){
            db.setNoOfItems(cart.getNoOfItems());
        }
        if(Objects.nonNull(cart.isConfirm()) &&
                !"".equalsIgnoreCase(String.valueOf(cart.isConfirm()))){
            db.setConfirm((cart.isConfirm()));
        }

        return cartRepository.save(db);
    }
}
