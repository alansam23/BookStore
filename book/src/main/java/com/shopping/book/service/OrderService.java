package com.shopping.book.service;

import com.shopping.book.entities.Order;
import com.shopping.book.repository.OrderRepository;
import com.shopping.book.service.iservice.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> fetchOrderList() {
        return orderRepository.findAll();
    }

    @Override
    public Order fetchOrderById(Long orderId)  {
        return orderRepository.findById(orderId).get();
    }

    @Override
    public void deleteOrderById(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public Order updateOrderById(Long bookId, Order order){
        Order db= orderRepository.findById(bookId).get();

        if(Objects.nonNull(order.getPrice()) &&
                !"".equalsIgnoreCase(order.getPrice())){
        db.setPrice(Long.valueOf(order.getPrice()));
    }
        if(Objects.nonNull(order.isConfirm()) &&
                !"".equalsIgnoreCase(String.valueOf(order.isConfirm()))){
        db.setConfirm((order.isConfirm()));
    }

        return orderRepository.save(db);
}

}