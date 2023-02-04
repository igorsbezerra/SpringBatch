package dev.igor.batchflatfile.writer;

import dev.igor.batchflatfile.domain.Client;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LeituraArquivoLarguraFixaWriterConfig {
    @Bean
    public ItemWriter<Client> leituraArquivoLarguraFixaWriter() {
        return items -> items.forEach(System.out::println);
    }
}
