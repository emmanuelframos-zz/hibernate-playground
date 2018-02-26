package com.test;

import com.hibernate.playground.domain.manytomany.unidirectional.Item;
import com.hibernate.playground.domain.manytomany.unidirectional.Order;
import com.hibernate.playground.service.OrderService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class ManyToManyUnidirectional extends BaseTest {

    private Logger logger = LoggerFactory.getLogger(ManyToManyUnidirectional.class);

    @Autowired
    private OrderService orderService;

    @Test
    public void saveOrder(){
        Item itemOne = new Item(BigDecimal.ONE);
        Item itemTwo = new Item(BigDecimal.TEN);

        Order order = new Order("order-6485");
        order.addItem(itemOne).addItem(itemTwo);

        orderService.save(order);

        logger.info(order.toString());

        order.removeItem(itemOne);

        orderService.save(order);

        logger.info(order.toString());

    }
}
