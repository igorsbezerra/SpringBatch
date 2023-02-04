package dev.igor.multiplefiles.step;

import dev.igor.multiplefiles.domain.Client;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultipleFilesStepConfig {
    private final StepBuilderFactory stepBuilderFactory;

    public MultipleFilesStepConfig(StepBuilderFactory stepBuilderFactory) {
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Bean
    public Step multipleFilesStep(MultiResourceItemReader<Client> multpleFilesClientTransactionReader, ItemWriter multipleFilesWriter) {
        return stepBuilderFactory
                .get("multipleFilesStep")
                .chunk(1)
                .reader(multpleFilesClientTransactionReader)
                .writer(multipleFilesWriter)
                .build();
    }
}
