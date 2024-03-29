package dev.igor.enviopromocoesclientesjob.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;

import dev.igor.enviopromocoesclientesjob.domain.InteresseProdutoCliente;

@Configuration
public class EnvioEmailClienteStepConfig {
    @Autowired private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step envioEmailClientesStep(
        ItemReader<InteresseProdutoCliente> lerInteresseProdutoClienteReader,
        ItemProcessor<InteresseProdutoCliente, SimpleMailMessage> processarEmailProdutoClienteProcessor,
        ItemWriter<SimpleMailMessage> enviarEmailProdutoClienteWriter
    ) {
        return stepBuilderFactory
            .get("envioEmailClientesStep")
            .<InteresseProdutoCliente, SimpleMailMessage>chunk(1)
            .reader(lerInteresseProdutoClienteReader)
            .processor(processarEmailProdutoClienteProcessor)
            .writer(enviarEmailProdutoClienteWriter)
            .build();
    }
}
