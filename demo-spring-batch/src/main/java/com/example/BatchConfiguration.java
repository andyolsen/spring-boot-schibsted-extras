package com.example;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
public class BatchConfiguration {

    @Bean
    public FlatFileItemReader<Employee> reader() {

        return new FlatFileItemReaderBuilder<Employee>()
                .name("employeeItemReader")
                .resource(new ClassPathResource("employee-data.csv"))
                .delimited()
                .delimiter(",")
                .names("firstname", "lastname", "salary")
                .targetType(Employee.class)
                .build();
    }

    @Bean
    public EmployeeItemProcessor processor() {
        return new EmployeeItemProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Employee> writer(DataSource dataSource) {

        return new JdbcBatchItemWriterBuilder<Employee>()
                .sql("""
                     INSERT INTO employee (firstname, lastname, salary) 
                     VALUES (:firstname, :lastname, :salary)
                     """)
                .dataSource(dataSource)
                .beanMapped()
                .build();
    }

    @Bean
    public Step step1(
            JobRepository jobRepository,
            DataSourceTransactionManager transactionManager,
            ItemReader<Employee> reader,
            ItemProcessor processor,
            ItemWriter<Employee> writer) {

        return new StepBuilder("step1", jobRepository)
                .<Employee, Employee> chunk(3, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    @Bean
    public Job job(
            JobRepository jobRepository,
            Step step1,
            JobCompletionNotificationListener listener) {

        return new JobBuilder("employeeEtlJob", jobRepository)
                .listener(listener)
                .start(step1)
//              .next(step2)
//              .next(step3)
                .build();
    }
}
