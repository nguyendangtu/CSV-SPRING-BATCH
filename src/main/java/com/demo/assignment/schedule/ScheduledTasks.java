package com.demo.assignment.schedule;

import com.demo.assignment.exception.GeneralLogs;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author JOHNNGUYEN
 * @Project assignment
 * @Created 04/05/2020 - 9:20 PM
 */
@Component
public class ScheduledTasks {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    @Qualifier("orderJob")
    Job orderJob;


    @GeneralLogs
    @Scheduled(cron = "${batch.cron.orderjob}")
    public void scheduleTaskWithCronExpression() throws Exception {
        JobParameters jobParameters = new JobParametersBuilder()
                .addDate("date", new Date())
                .toJobParameters();
        jobLauncher.run(orderJob, jobParameters);
    }
}
