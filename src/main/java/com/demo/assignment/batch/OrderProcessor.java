package com.demo.assignment.batch;


import com.demo.assignment.domain.Order;
import com.demo.assignment.exception.GeneralLogs;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * @author JOHNNGUYEN
 * @Project assignment
 * @Created 04/05/2020 - 8:27 PM
 */
@Component
public class OrderProcessor implements ItemProcessor<Order, Order> {
    @Override
    public Order process(final Order order) throws Exception {
        return order;
    }
}
