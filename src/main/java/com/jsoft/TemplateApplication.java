package com.jsoft;

import com.jsoft.common.annotation.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication(scanBasePackages = {"com.jsoft"})
@ComponentScan(
        includeFilters = @ComponentScan.Filter(
                type = FilterType.ANNOTATION,
                classes = {
                        Aggregate.class,
                        ApplicationService.class,
                        DomainEntity.class,
                        DomainService.class,
                        DomainRepository.class,
                        ValueObject.class
                })
)
public class TemplateApplication {

    public static void main(String[] args) {

        SpringApplication.run(TemplateApplication.class, args);
    }
}
