package com.demo.assignment.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "STORE_ORDER")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long ID;

    @Column(name = "ORDER_ID")
    private String orderId;

    @Column(name = "ORDER_DATE")
    private LocalDate orderDate;

    @Column(name = "SHIP_DATE")
    private LocalDate shipDate;

    @Column(name = "SHIP_MODE")
    private String shipMode;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Column(name = "DISCOUNT")
    private BigDecimal discount;

    @Column(name = "PROFIT")
    private BigDecimal profit;

    @Column(name = "PRODUCT_ID")
    private String productId;

    @Column(name = "CUSTOMER_NAME")
    private String customerName;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "CUSTOMER_ID")
    private String customerID;

    @Column(name = "PRODUCT_NAME")
    private String productName;

}
