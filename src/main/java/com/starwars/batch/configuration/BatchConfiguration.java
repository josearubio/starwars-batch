package com.starwars.batch.configuration;

import com.starwars.batch.tasklet.HelloWorldTasklet;
import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jaro on 21/07/17.
 */
//@Configuration
//@EnableBatchProcessing
public class BatchConfiguration {

    @Bean
    public Step helloWorldStep(StepBuilderFactory stepBuilderFactory, HelloWorldTasklet helloWorldTasklet){
        return stepBuilderFactory
                .get("helloWorldStep")
                .tasklet(helloWorldTasklet)
                .build();
    }

    @Bean
    public Job helloWorldJob(JobBuilderFactory jobBuilderFactory, Step helloWorldStep){
        return jobBuilderFactory.get("helloWorldJob")
                .incrementer(new RunIdIncrementer())
                .start(helloWorldStep)
                .build();
    }
}
