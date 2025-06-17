package com.ilan;

import com.ilan.service.DataLoadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import static org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO;

@Slf4j
@SpringBootApplication
@EnableSpringDataWebSupport(pageSerializationMode = VIA_DTO)
public class H2Application {

    public static void main(String[] args) {
        SpringApplication.run(H2Application.class, args);
    }

    @Bean
    public CommandLineRunner bulkDataLoad(DataLoadService dataLoadService) {
        return args -> {
            log.info("############ Starting to export the Sql Class############");
            dataLoadService.dataLoad();
            dataLoadService.isDataLoaded();
            log.info("######### data load completed #########");
        };
    }
}