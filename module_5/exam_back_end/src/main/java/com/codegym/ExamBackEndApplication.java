package com.codegym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class ExamBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamBackEndApplication.class, args);
    }

}
