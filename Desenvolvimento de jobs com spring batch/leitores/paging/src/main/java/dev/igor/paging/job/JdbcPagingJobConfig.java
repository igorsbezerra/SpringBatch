package dev.igor.paging.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class JdbcPagingJobConfig {
    private final JobBuilderFactory jobBuilderFactory;

    public JdbcPagingJobConfig(JobBuilderFactory jobBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
    }

    @Bean
    public Job jdbcPagingJob(Step jdbcPagingStep) {
        return jobBuilderFactory.get("jdbcPagingJob")
                .start(jdbcPagingStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }
}
