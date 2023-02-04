package deve.igor.delimitedfile.step;

import deve.igor.delimitedfile.domain.Client;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DelimitedFileStepConfig {
    private final StepBuilderFactory stepBuilderFactory;

    public DelimitedFileStepConfig(StepBuilderFactory stepBuilderFactory) {
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean
    public Step delimitedFileStep(ItemReader<Client> delimitedFileReader, ItemWriter<Client> delimitedFileWriter) {
        return stepBuilderFactory.get("delimitedFileStep")
                .<Client, Client>chunk(1)
                .reader(delimitedFileReader)
                .writer(delimitedFileWriter)
                .build();
    }
}
