package com.shopping.book.controller;

import com.shopping.book.entities.Order;
import com.shopping.book.repository.OrderRepository;
import com.shopping.book.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderRepository orderRepository;
    @GetMapping("order&cart")
    public List<Order> getCarts(){
        return orderRepository.findAll();
    }
    @PostMapping("/order")
    public Order saveOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    @GetMapping("/order")
    public List<Order> fetchOrderList() {
        return orderService.fetchOrderList();
    }

    @GetMapping("/order/{id}")
    public Order fetchOrderById(@PathVariable("id") Long orderId) {
        return orderService.fetchOrderById(orderId);
    }

    @DeleteMapping("/order/{id}")
    public String deleteOrderById(@PathVariable("id") Long orderId) {
        orderService.deleteOrderById(orderId);
        return "Order Deleted Successfully";
    }

    @PutMapping("/order/{id}")
    public Order updateOrderById(@PathVariable("id") Long orderId,
                               @RequestBody Order order) {
        return orderService.updateOrderById(orderId, order);
    }
}

