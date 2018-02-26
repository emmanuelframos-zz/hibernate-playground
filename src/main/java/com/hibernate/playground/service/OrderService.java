package com.hibernate.playground.service;

import com.hibernate.playground.domain.manytomany.unidirectional.Order;
import com.hibernate.playground.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public Order save(Order order){
        return orderRepository.save(order);
    }
}
