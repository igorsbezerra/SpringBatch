package dev.igor.processadoresvalidacao.step;

import dev.igor.processadoresvalidacao.domain.Client;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcessorValidationStepConfig {
    private final StepBuilderFactory stepBuilderFactory;

    public ProcessorValidationStepConfig(StepBuilderFactory stepBuilderFactory) {
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean
    public Step processorValidationStep(ItemReader<Client> processorValidationReader, ItemProcessor<Client, Client> processorValidationProcessor, ItemWriter<Client> processorValidationWriter) {
        return stepBuilderFactory
                .get("processorValidationStep")
                .<Client, Client>chunk(1)
                .reader(processorValidationReader)
                .processor(processorValidationProcessor)
                .writer(processorValidationWriter)
                .build();
    }
}
