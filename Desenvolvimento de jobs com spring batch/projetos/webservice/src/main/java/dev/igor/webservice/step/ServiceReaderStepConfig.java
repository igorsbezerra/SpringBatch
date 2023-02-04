package dev.igor.webservice.step;

import dev.igor.webservice.domain.User;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceReaderStepConfig {
    private final StepBuilderFactory stepBuilderFactory;
    private final int chunkSize;

    public ServiceReaderStepConfig(StepBuilderFactory stepBuilderFactory, @Value("${chunk.size}") int chunkSize) {
        this.stepBuilderFactory = stepBuilderFactory;
        this.chunkSize = chunkSize;
    }

    @Bean
    public Step step(ItemReader<User> reader, ItemWriter<User> writer) {
        return stepBuilderFactory
                .get("step")
                .<User, User>chunk(chunkSize)
                .reader(reader)
                .writer(writer)
                .build();
    }
}
