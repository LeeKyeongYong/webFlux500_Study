package com.exambasic.fluxweb.config;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.core.DefaultReactiveDataAccessStrategy;
import org.springframework.data.r2dbc.core.R2dbcEntityOperations;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.r2dbc.dialect.OracleDialect;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.connection.R2dbcTransactionManager;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.transaction.ReactiveTransactionManager;

@Configuration
@EnableR2dbcRepositories(
        basePackages = "com.exambasic.fluxweb.second.repository",
        entityOperationsRef = "secondEntityOperations"
)
public class SecondDBConfig {

    @Bean
    @Qualifier("second")
    public ConnectionFactory secondConnectionFactory(){

        return ConnectionFactories.get(ConnectionFactoryOptions.parse("r2dbc:oracle:thin:@59.32.16.42:1521:xe")
               .mutate()
               .option(ConnectionFactoryOptions.USER,"????")
               .option(ConnectionFactoryOptions.PASSWORD,"????")
               .build());
    }

    @Bean
    public R2dbcEntityOperations secondEntityOpertions(@Qualifier("second")ConnectionFactory connectionFactory){
        DefaultReactiveDataAccessStrategy strategy =new DefaultReactiveDataAccessStrategy(OracleDialect.INSTANCE);
        DatabaseClient databaseClient=DatabaseClient.builder()
                .connectionFactory(connectionFactory)
                .build();
        return new R2dbcEntityTemplate(databaseClient,strategy);
    }

    @Bean
    public ReactiveTransactionManager secondTranscationManager(@Qualifier("second")ConnectionFactory connectionFactory){
        return new R2dbcTransactionManager(connectionFactory);
    }
}



