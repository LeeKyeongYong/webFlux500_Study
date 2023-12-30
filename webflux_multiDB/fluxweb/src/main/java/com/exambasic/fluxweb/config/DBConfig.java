package com.exambasic.fluxweb.config;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.r2dbc.connection.R2dbcTransactionManager;
import org.springframework.transaction.ReactiveTransactionManager;

@Configuration
@ComponentScan(basePackages = "com.exambasic.fluxweb")
public class DBConfig {

    @Bean
    public ConnectionFactory connectionFactory(){
        return ConnectionFactories.get(
                ConnectionFactoryOptions.parse("r2dbc:mysql://localhost:3306/calendar?useSSL=false&useUnicode=true&serverTimezone=Asia/Seoul&allowPublicKeyRetrieval=true")
                        .mutate()
                        .option(ConnectionFactoryOptions.USER,"hos")
                        .option(ConnectionFactoryOptions.PASSWORD,"2tkdalsz")
                .build());

    }

    @Bean
    public ReactiveTransactionManager transactionManager(ConnectionFactory connectionFactory) {

        return new R2dbcTransactionManager(connectionFactory);
    }
}
