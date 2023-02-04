package dev.igor.processadoresvalidacao.writer;

import dev.igor.processadoresvalidacao.domain.Client;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcessorValidationWriterConfig {
    @Bean
    public ItemWriter<Client> processorValidationWriter() {
        return clients -> clients.forEach(System.out::println);
    }
}
