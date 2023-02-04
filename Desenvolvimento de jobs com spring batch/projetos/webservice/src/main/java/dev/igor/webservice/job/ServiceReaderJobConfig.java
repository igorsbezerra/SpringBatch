package dev.igor.webservice.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class ServiceReaderJobConfig {
    private final JobBuilderFactory jobBuilderFactory;

    public ServiceReaderJobConfig(JobBuilderFactory jobBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
    }

    @Bean
    public Job job(Step serviceReaderStep) {
        return jobBuilderFactory
                .get("job")
                .start(serviceReaderStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }
}
