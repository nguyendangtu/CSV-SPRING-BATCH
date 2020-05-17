package com.demo.assignment.batch;

import com.demo.assignment.domain.Order;
import com.demo.assignment.exception.GeneralLogs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

/**
 * @author JOHNNGUYEN
 * @Project assignment
 * @Created 04/05/2020 - 8:27 PM
 */
@Component
public class OrdersJob extends JobExecutionListenerSupport {

    private final Logger logger = LoggerFactory.getLogger(OrdersJob.class);

    @Autowired
    JobBuilderFactory jobBuilderFactory;

    @Autowired
    StepBuilderFactory stepBuilderFactory;

    @Value("${input.file}")
    Resource resource;

    @Value("${input.chuckSize}")
    Integer chuckSize;

    @Autowired
    OrderProcessor processor;

    @Autowired
    OrderWriter writer;

    @GeneralLogs
    @Bean(name = "orderJob")
    public Job orderJob() {
        Step step = stepBuilderFactory.get("step-1")
                .<Order, Order>chunk(chuckSize)
                .reader(new OrderReader(resource))
                .processor(processor)
                .writer(writer)
                .build();

        Job job = jobBuilderFactory.get("sale-store-job")
                .incrementer(new RunIdIncrementer())
                .listener(this)
                .start(step)
                .build();

        return job;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            logger.info("BATCH JOB COMPLETED SUCCESSFULLY");
        }
    }
}
