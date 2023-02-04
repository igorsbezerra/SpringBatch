package dev.igor.processadoresscript.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.support.builder.ScriptItemProcessorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.igor.processadoresscript.domain.Client;

@Configuration
public class ProcessorScriptProcessorConfig {
    @Bean
    ItemProcessor<Client, Client> processorScriptProcessor() {
        return new ScriptItemProcessorBuilder<Client, Client>()
            .language("nashorn")
            .scriptSource(
                "var email = item.getEmail();" +
                "var existsFile = `ls | grep ${email}.txt`;" +
                "if (!existsFile) item; else null;"
                )
            .build();
    }
}
