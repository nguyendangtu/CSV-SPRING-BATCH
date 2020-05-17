package com.demo.assignment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Order Job Controller populate API to invoke order batch jobs
 *
 * @author JOHNNGUYEN
 * @Project assignment
 * @Created 04/05/2020 - 9:03 PM
 */
@RestController
public class OrderJobInvokeController {

    private final Logger logger = LoggerFactory.getLogger(OrderJobInvokeController.class);

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    @Qualifier("orderJob")
    Job orderJob;

    @GetMapping(path = "/run-batch-job/order-job", consumes = "application/json", produces = "application/json")
    public String runOrderJob() {

        JobParameters jobParameters = new JobParametersBuilder()
                .addDate("date", new Date())
                .toJobParameters();
        new Thread(() -> {
            try {
                jobLauncher.run(orderJob, jobParameters);
            } catch (Exception e) {
                logger.error("order-job" + e.getMessage());
            }
        }).start();

        return "Batch orderJob has been invoked";
    }
}
