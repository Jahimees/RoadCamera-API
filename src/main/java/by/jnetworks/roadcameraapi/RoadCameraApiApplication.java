package by.jnetworks.roadcameraapi;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Start application
 */
@SpringBootApplication
public class RoadCameraApiApplication {

    private static final Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        logger.info("Api starting...");
        SpringApplication.run(RoadCameraApiApplication.class, args);
    }

}
