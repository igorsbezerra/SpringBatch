package dev.igor.processadoresscript.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.igor.processadoresscript.domain.Client;

@Configuration
public class ProcessorScriptStepConfig {
    private final StepBuilderFactory stepBuilderFactory;

    public ProcessorScriptStepConfig(StepBuilderFactory stepBuilderFactory) {
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean
    Step processorScriptStep(
        ItemReader<Client> processorScriptReader,
        ItemProcessor<Client, Client> processorScriptProcessor,
        org.springframework.batch.item.ItemWriter<Client> processorScriptWriter
    ) {
        return stepBuilderFactory
            .get("processorScriptStep")
            .<Client, Client>chunk(1)
            .reader(processorScriptReader)
            .processor(processorScriptProcessor)
            .writer(processorScriptWriter)
            .build();
    }
}
