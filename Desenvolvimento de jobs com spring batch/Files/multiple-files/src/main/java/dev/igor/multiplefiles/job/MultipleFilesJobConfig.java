package dev.igor.multiplefiles.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class MultipleFilesJobConfig {
    private final JobBuilderFactory jobBuilderFactory;

    public MultipleFilesJobConfig(JobBuilderFactory jobBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
    }

    @Bean
    public Job multipleFilesJob(Step multipleFilesStep) {
        return jobBuilderFactory
                .get("multipleFilesJob")
                .start(multipleFilesStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }
}
