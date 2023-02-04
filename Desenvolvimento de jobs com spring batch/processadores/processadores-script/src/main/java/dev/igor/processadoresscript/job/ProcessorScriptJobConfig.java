package dev.igor.processadoresscript.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class ProcessorScriptJobConfig {

    private final JobBuilderFactory jobBuilderFactory;

    public ProcessorScriptJobConfig(JobBuilderFactory jobBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
    }

    @Bean
    Job processorScriptJob(Step processorScriptStep) {
        return jobBuilderFactory
            .get("processorScriptJob")
            .start(processorScriptStep)
            .incrementer(new RunIdIncrementer())
            .build();
    }
}
