package dev.igor.multipleformatfiles.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultipleFormatFilesWriterConfig {
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Bean
    public ItemWriter multipleFormatFilesWriter() {
        return items -> items.forEach(System.out::println);
    }
}
