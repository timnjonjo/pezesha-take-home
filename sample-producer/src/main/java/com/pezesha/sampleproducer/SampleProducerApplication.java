package com.pezesha.sampleproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SampleProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleProducerApplication.class, args);
    }

}
