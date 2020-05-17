package com.demo.assignment.batch;

import com.demo.assignment.constant.OrderConstant;
import com.demo.assignment.domain.Order;
import com.demo.assignment.exception.GeneralLogs;
import com.demo.assignment.utils.DateUtil;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

/**
 * @author JOHNNGUYEN
 * @Project assignment
 * @Created 04/05/2020 - 8:27 PM
 */
@Component
public class OrderFieldSetMapper implements FieldSetMapper<Order> {
    @GeneralLogs
    @Override
    public Order mapFieldSet(FieldSet fieldSet) throws BindException {
        final Order order = new Order();
        order.setOrderId(fieldSet.readString("Order ID"));
        order.setOrderDate(DateUtil.convertStringToDate(fieldSet.readString("Order Date"), OrderConstant.DATE_FORMAT_DD_DOT_MM_DOT_YY));
        order.setShipDate(DateUtil.convertStringToDate(fieldSet.readString("Ship Date"), OrderConstant.DATE_FORMAT_DD_DOT_MM_DOT_YY));
        order.setShipMode(fieldSet.readString("Ship Mode"));
        order.setQuantity(fieldSet.readInt("Quantity"));
        order.setDiscount(fieldSet.readBigDecimal("Discount"));
        order.setProfit(fieldSet.readBigDecimal("Profit"));
        order.setProductId(fieldSet.readString("Product ID"));
        order.setCustomerName(fieldSet.readString("Customer Name"));
        order.setCategory(fieldSet.readString("Category"));
        order.setCustomerID(fieldSet.readString("Customer ID"));
        order.setProductName(fieldSet.readString("Product Name"));
        return order;
    }

}
