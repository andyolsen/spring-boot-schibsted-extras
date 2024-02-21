package com.example;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.JobExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionNotificationListener implements JobExecutionListener {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void afterJob(JobExecution jobExecution) {

        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {

            System.out.println("IN JOB COMPLETION NOTIFICATION LISTENER:");

            jdbcTemplate
                    .query("SELECT firstname, lastname, salary FROM employee", new DataClassRowMapper<>(Employee.class))
                    .forEach(emp -> System.out.println(emp));
        }
    }
}