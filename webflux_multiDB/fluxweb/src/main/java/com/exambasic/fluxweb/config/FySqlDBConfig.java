package com.exambasic.fluxweb.config;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.r2dbc.core.DefaultReactiveDataAccessStrategy;
import org.springframework.data.r2dbc.core.R2dbcEntityOperations;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.r2dbc.dialect.MySqlDialect;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.connection.R2dbcTransactionManager;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.transaction.ReactiveTransactionManager;

@Configuration
@EnableR2dbcRepositories(
        basePackages = "com.exambasic.fluxweb.first.repository",
        entityOperationsRef = "firstEntityOperations"
)
public class FySqlDBConfig {

    @Primary
    @Bean
    @Qualifier("first")
    public ConnectionFactory firstConnectionFactory(){
        return ConnectionFactories.get(
                ConnectionFactoryOptions.parse("r2dbc:mysql://59.32.16.42:3306/calendar?useSSL=false&useUnicode=true&serverTimezone=Asia/Seoul&allowPublicKeyRetrieval=true")
                .mutate()
                .option(ConnectionFactoryOptions.USER,"????")
                .option(ConnectionFactoryOptions.PASSWORD,"????")
                .build());
    }

    @Primary
    @Bean
    public R2dbcEntityOperations firstEntityOperations(@Qualifier("first") ConnectionFactory connectionFactory){
        DefaultReactiveDataAccessStrategy strategy = new DefaultReactiveDataAccessStrategy(MySqlDialect.INSTANCE);

        DatabaseClient databaseClient = DatabaseClient.builder()
                .connectionFactory(connectionFactory)
                .build();

        return new R2dbcEntityTemplate(databaseClient,strategy);
    }

    @Primary
    @Bean
    public ReactiveTransactionManager firstTransactionManager(@Qualifier("first") ConnectionFactory connectionFactory){

        return new R2dbcTransactionManager(connectionFactory);
    }

}
