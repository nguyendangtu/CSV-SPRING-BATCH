package com.demo.assignment.repository;

import com.demo.assignment.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author JOHNNGUYEN
 * @Project assignment
 * @Created 04/05/2020 - 8:50 PM
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
}
