package deve.igor.delimitedfile.reader;

import deve.igor.delimitedfile.domain.Client;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class DelimitedFileReaderConfig {
    @Bean
    @StepScope
    public FlatFileItemReader<Client> delimitedFileReader(@Value("#{jobParameters['file']}") Resource file) {
        return new FlatFileItemReaderBuilder<Client>()
                .name("delimitedFileReader")
                .resource(file)
                .delimited()
                .names(new String[]{"name", "surname", "age", "email"})
                .targetType(Client.class)
                .build();
    }
}
