package com.demo.assignment.batch;

import com.demo.assignment.domain.Order;
import com.demo.assignment.exception.GeneralLogs;
import com.demo.assignment.repository.OrderRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author JOHNNGUYEN
 * @Project assignment
 * @Created 04/05/2020 - 8:27 PM
 */
@Component
public class OrderWriter implements ItemWriter<Order> {

    @Autowired
    private OrderRepository repo;

    @GeneralLogs
    @Override
    @Transactional
    public void write(List<? extends Order> orders) {
        repo.saveAll(orders);
    }
}
