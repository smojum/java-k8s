package com.smojum.javak8s;

import io.r2dbc.spi.ConnectionFactory;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnCloudPlatform;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.cloud.CloudPlatform;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

import java.util.Objects;

@Configuration
@Log4j2
public class CustomerConfig {
    @Bean
    @ConditionalOnCloudPlatform(CloudPlatform.KUBERNETES)
    ApplicationListener<ApplicationReadyEvent> runningInKubernetes(
            @Value("${execution-environment:localhost}") String executionEnv) {
        return event -> log.info("Hello, world, from " + executionEnv + "!");
    }

    @EventListener
    public void availabilityChangeEvent(AvailabilityChangeEvent<?> ace) {
        log.info(Objects.requireNonNull(ace.getResolvableType()) + ":" +
                        ace.getState().toString());
    }

    //data set up as we are using in memory database. would not need this in production.
    @Bean
    ConnectionFactoryInitializer initializer(@Qualifier("connectionFactory") ConnectionFactory connectionFactory) {

        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
        initializer.setConnectionFactory(connectionFactory);
        initializer.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource("data.sql")));

        return initializer;
    }

}
