package dev.igor.processadoresscript.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.igor.processadoresscript.domain.Client;

@Configuration
public class ProcessorScriptWriterConfig {
    @Bean
    ItemWriter<Client> processorScriptWriter() {
        return clients -> clients.forEach(System.out::println);
    }
}
