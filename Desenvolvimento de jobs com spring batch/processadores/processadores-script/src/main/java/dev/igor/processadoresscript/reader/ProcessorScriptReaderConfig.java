package dev.igor.processadoresscript.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import dev.igor.processadoresscript.domain.Client;

@Configuration
public class ProcessorScriptReaderConfig {
    @StepScope
    @Bean
    FlatFileItemReader<Client> processorScriptReader(
        @Value("#{jobParameters['file']}") Resource file
    ) {
        return new FlatFileItemReaderBuilder<Client>()
            .name("processorScriptReader")
            .resource(file)
            .delimited()
            .names("name", "age", "email")
            .targetType(Client.class)
            .build();
    }
}
