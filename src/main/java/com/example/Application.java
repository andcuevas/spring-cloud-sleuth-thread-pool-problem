package com.example;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

    private static final Log log = LogFactory.getLog(Application.class);

    @Autowired
    private AsyncTask asyncTask;

    @RequestMapping("/with_pool")
    public String withPool() {

        log.info("Executing with pool.");
        asyncTask.runWithPool();

        return "with pool";

    }

    @RequestMapping("/without_pool")
    public String withoutPool() {

        log.info("Executing without pool.");
        asyncTask.runWithoutPool();

        return "without pool";

    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}