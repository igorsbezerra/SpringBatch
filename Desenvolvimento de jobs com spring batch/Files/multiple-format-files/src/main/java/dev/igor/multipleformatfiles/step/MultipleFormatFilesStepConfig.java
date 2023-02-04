package dev.igor.multipleformatfiles.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultipleFormatFilesStepConfig {
    private final StepBuilderFactory stepBuilderFactory;

    public MultipleFormatFilesStepConfig(StepBuilderFactory stepBuilderFactory) {
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Bean
    public Step multipleFormatFileStep(FlatFileItemReader multipleFormatFilesReader, ItemWriter multipleFormatFilesWriter) {
        return stepBuilderFactory.get("multipleFormatFileStep")
                .chunk(1)
                .reader(multipleFormatFilesReader)
                .writer(multipleFormatFilesWriter)
                .build();
    }
}
