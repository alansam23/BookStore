package com.shopping.book.service.iservice;

import com.shopping.book.entities.Order;
import java.util.List;

public interface IOrderService {
    public Order saveOrder(Order order) ;

    public List<Order> fetchOrderList();

    public Order fetchOrderById(Long orderId);
    public void deleteOrderById(Long orderId);

    public Order updateOrderById(Long bookId, Order order);
}
