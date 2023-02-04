package dev.igor.multiplelines.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class MultipleLinesJobConfig {
    private final JobBuilderFactory jobBuilderFactory;

    public MultipleLinesJobConfig(JobBuilderFactory jobBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
    }

    @Bean
    public Job multipleLinesJob(Step multipleLinesStep) {
        return jobBuilderFactory.get("multipleLinesJob")
                .start(multipleLinesStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }
}
