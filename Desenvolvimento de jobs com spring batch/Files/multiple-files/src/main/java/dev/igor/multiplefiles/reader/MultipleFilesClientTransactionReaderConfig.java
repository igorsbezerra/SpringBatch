package dev.igor.multiplefiles.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.builder.MultiResourceItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class MultipleFilesClientTransactionReaderConfig {
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Bean
    @StepScope
    public MultiResourceItemReader multpleFilesClientTransactionReader(
            @Value("#{jobParameters['files']}") Resource[] files,
            FlatFileItemReader readingMultiplesFilesReader) {
        return new MultiResourceItemReaderBuilder()
            .name("multpleFilesClientTransactionReader")
                .resources(files)
                .delegate(new FileClientTransactionReader(readingMultiplesFilesReader))
                .build();
    }
}
