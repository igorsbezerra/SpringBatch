package dev.igor.batchflatfile.reader;

import dev.igor.batchflatfile.domain.Client;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class LeituraArquivoLarguraFixaReaderConfig {
    @Bean
    @StepScope
    public FlatFileItemReader<Client> leituraArquivoLarguraFixaReader(@Value("#{jobParameters['file']}") Resource file) {
        return new FlatFileItemReaderBuilder<Client>().name("leituraArquivoLarguraFixaReader")
                .resource(file)
                .fixedLength()
                .columns(new Range[]{new Range(1, 10), new Range(11, 20), new Range(21, 23), new Range(24, 43)})
                .names(new String[]{"name", "surname", "age", "email"})
                .targetType(Client.class)
                .build();
    }
}
