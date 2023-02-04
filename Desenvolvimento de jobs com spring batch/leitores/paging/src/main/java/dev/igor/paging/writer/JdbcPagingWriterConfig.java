package dev.igor.paging.writer;

import dev.igor.paging.domain.Client;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JdbcPagingWriterConfig {
    @Bean
    public ItemWriter<Client> jdbcWriter() {
        return clients -> clients.forEach(System.out::println);
    }
}
