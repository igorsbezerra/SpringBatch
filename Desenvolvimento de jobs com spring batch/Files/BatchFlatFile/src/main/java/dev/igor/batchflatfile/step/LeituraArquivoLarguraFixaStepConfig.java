package dev.igor.batchflatfile.step;

import dev.igor.batchflatfile.domain.Client;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LeituraArquivoLarguraFixaStepConfig {
    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step leituraArquivoLarguraFixaStep(ItemReader<Client> leituraArquivoLarguraFixaReader,
                                              ItemWriter<Client> leituraArquivoLarguraFixaWriter) {
        return stepBuilderFactory
                .get("leituraArquivoLarguraFixaStep")
                .<Client, Client>chunk(1)
                .reader(leituraArquivoLarguraFixaReader)
                .writer(leituraArquivoLarguraFixaWriter)
                .build();
    }
}
