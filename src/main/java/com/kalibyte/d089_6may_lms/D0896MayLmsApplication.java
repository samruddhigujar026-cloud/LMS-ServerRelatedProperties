package com.kalibyte.d089_6may_lms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class D0896MayLmsApplication {

    private static final Logger logger = LogManager.getLogger(D0896MayLmsApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(D0896MayLmsApplication.class, args);
        logger.info("Info Log - Application Started");
        logger.debug("Debug Log - Hello World");
        logger.error("Error Log - Hello World");
        logger.warn("Warn Log - Hello World");
        logger.fatal("Fatal Log - Hello World");
    }

}
