package dev.igor.multiplelines.step;

import dev.igor.multiplelines.reader.FileClientTransactionReader;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultipleLinesStepConfig {
    private final StepBuilderFactory stepBuilderFactory;

    public MultipleLinesStepConfig(StepBuilderFactory stepBuilderFactory) {
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean
    public Step multipleLinesStep(FlatFileItemReader multipleLinesReader, ItemWriter multipleLinesWriter) {
        return stepBuilderFactory.get("multipleLinesStep")
                .chunk(1)
                .reader(new FileClientTransactionReader(multipleLinesReader))
                .writer(multipleLinesWriter)
                .build();
    }
}
