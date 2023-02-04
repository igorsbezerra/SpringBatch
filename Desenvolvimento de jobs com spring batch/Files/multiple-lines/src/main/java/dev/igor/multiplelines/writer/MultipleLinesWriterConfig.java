package dev.igor.multiplelines.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultipleLinesWriterConfig {
    @Bean
    public ItemWriter multipleLineWriter() {
        return items -> items.forEach(System.out::println);
    }
}
