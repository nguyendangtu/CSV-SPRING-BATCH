package com.demo.assignment.controller;

import com.demo.assignment.BaseTest;
import com.demo.assignment.domain.Order;
import com.demo.assignment.repository.OrderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author JOHNNGUYEN
 * @Project assignment
 * @Created 04/05/2020 - 9:03 PM
 */
public class OrderJobInvokeControllerTest extends BaseTest {

    @Autowired
    private OrderRepository repo;

    @Test
    public void runOrderJob() throws Throwable {
        String url = "/run-batch-job/order-job";
        MvcResult result = this.mockMvc.perform(get(url)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        Assert.assertEquals("Batch orderJob has been invoked", result.getResponse().getContentAsString());
        TimeUnit.SECONDS.sleep(30);
        List<Order> orders = repo.findAll();
        Assert.assertNotNull(orders);
        Assert.assertTrue(orders.size() == 11);

    }
}