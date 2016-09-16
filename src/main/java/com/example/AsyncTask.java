package com.example;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncTask {

    private static final Log log = LogFactory.getLog(Application.class);

    @Async("poolTaskExecutor")
    public void runWithPool() {
        log.info("This task is running with a pool.");
    }

    @Async
    public void runWithoutPool() {
        log.info("This task is running without a pool.");
    }

}
