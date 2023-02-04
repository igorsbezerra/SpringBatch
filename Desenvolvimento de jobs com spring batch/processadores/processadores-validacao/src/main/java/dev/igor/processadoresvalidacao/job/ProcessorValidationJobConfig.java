package dev.igor.processadoresvalidacao.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class ProcessorValidationJobConfig {
    private final JobBuilderFactory jobBuilderFactory;

    public ProcessorValidationJobConfig(JobBuilderFactory jobBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
    }

    @Bean
    public Job processorValidationJob(Step processorValidationStep) {
        return jobBuilderFactory
                .get("processorValidationJob")
                .start(processorValidationStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }
}
