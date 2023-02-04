package dev.igor.cursor.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.igor.cursor.domain.Client;

@Configuration
public class JdbcCursorReaderStepConfig {

    private final StepBuilderFactory stepBuilderFactory;

    public JdbcCursorReaderStepConfig(StepBuilderFactory stepBuilderFactory) {
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean
    Step jdbcCursorReaderStep(ItemReader<Client> jdbcCursorReader, ItemWriter<Client> jdbcCursorWriter) {
        return stepBuilderFactory
            .get("cursorStep")
            .<Client, Client>chunk(1)
            .reader(jdbcCursorReader)
            .writer(jdbcCursorWriter)
            .build();

    }
}
