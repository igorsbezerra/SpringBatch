package dev.igor.cursor.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class JdbcCursorReaderJobConfig {
    private final JobBuilderFactory jobBuilderFactory;

    public JdbcCursorReaderJobConfig(JobBuilderFactory jobBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
    }

    @Bean
    Job jdbcCursorReaderJob(Step jdbcCursorReaderStep) {
        return jobBuilderFactory
            .get("jdbcCursorReaderJob")
            .start(jdbcCursorReaderStep)
            .incrementer(new RunIdIncrementer())
            .build();
    }   
}
