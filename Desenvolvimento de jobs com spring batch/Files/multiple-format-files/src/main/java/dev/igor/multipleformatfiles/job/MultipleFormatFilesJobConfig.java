package dev.igor.multipleformatfiles.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class MultipleFormatFilesJobConfig {
    private final JobBuilderFactory jobBuilderFactory;

    public MultipleFormatFilesJobConfig(JobBuilderFactory jobBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
    }

    @Bean
    public Job multipleFormatFileJob(Step multipleFormatFilesStep) {
        return jobBuilderFactory.get("multipleFormatFileJob")
                .start(multipleFormatFilesStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }
}
