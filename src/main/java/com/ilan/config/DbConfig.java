package com.ilan.config;


import com.querydsl.sql.H2Templates;
import com.querydsl.sql.SQLQueryFactory;
import com.querydsl.sql.SQLTemplates;
import com.querydsl.sql.spring.SpringConnectionProvider;
import com.querydsl.sql.spring.SpringExceptionTranslator;
import com.querydsl.sql.types.LocalDateTimeType;
import com.querydsl.sql.types.LocalDateType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;


@Configuration
public class DbConfig {
    private static final Logger log = LoggerFactory.getLogger(DbConfig.class);

    @Bean
    public com.querydsl.sql.Configuration querydslConfiguration() {
        SQLTemplates templates = H2Templates.builder()
                .printSchema() // to include the schema in the output
                //.quote()       // to quote names
                .newLineToSingleSpace() // to replace new lines with single space in the output
                //.escape(ch)    // to set the escape char
                .build();
        com.querydsl.sql.Configuration configuration = new com.querydsl.sql.Configuration(templates);
        configuration.setExceptionTranslator(new SpringExceptionTranslator());
        configuration.register(new LocalDateTimeType());
        configuration.register(new LocalDateType());
        configuration.setUseLiterals(Boolean.TRUE);
        return configuration;
    }


    @Bean
    public SQLQueryFactory sqlQueryFactory(DataSource dataSource, com.querydsl.sql.Configuration configuration) {
        SpringConnectionProvider provider = new SpringConnectionProvider(dataSource);
        //return new SQLQueryFactory(configuration, provider);
        return new SQLQueryFactory(configuration, new TransactionAwareDataSourceProxy(dataSource));
    }
}
