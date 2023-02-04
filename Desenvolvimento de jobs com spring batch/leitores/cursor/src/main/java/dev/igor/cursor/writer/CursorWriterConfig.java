package dev.igor.cursor.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.igor.cursor.domain.Client;

@Configuration
public class CursorWriterConfig {
    @Bean
    ItemWriter<Client> cursorWriter() {
        return clients -> clients.forEach(System.out::println);
    }
}
