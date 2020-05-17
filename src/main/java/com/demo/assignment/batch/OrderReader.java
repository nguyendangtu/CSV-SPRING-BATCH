package com.demo.assignment.batch;

import com.demo.assignment.domain.Order;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.separator.DefaultRecordSeparatorPolicy;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.Resource;

/**
 * @author JOHNNGUYEN
 * @Project assignment
 * @Created 04/05/2020 - 8:27 PM
 */
public class OrderReader extends FlatFileItemReader<Order> {

    /***
     * Constructor for OrderReader which reading resource and mapping to Order object
     * @param resource
     */
    public OrderReader(Resource resource) {
        super();
        setResource(resource);
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        setLinesToSkip(1);
        setRecordSeparatorPolicy(new DefaultRecordSeparatorPolicy());
        lineTokenizer.setNames(new String[]{"Row ID", "Order ID", "Order Date", "Ship Date", "Ship Mode", "Customer ID", "Customer Name", "Segment", "Country", "City", "State", "Postal Code", "Region", "Product ID", "Category", "Sub-Category", "Product Name", "Sales", "Quantity", "Discount", "Profit"});
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);

        //set line mapper
        DefaultLineMapper<Order> defaultLineMapper = new DefaultLineMapper<>();
        defaultLineMapper.setLineTokenizer(lineTokenizer);
        defaultLineMapper.setFieldSetMapper(new OrderFieldSetMapper());
        setLineMapper(defaultLineMapper);
    }
}
