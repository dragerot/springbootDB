package net.toregard;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Configuration
//@EnableAutoConfiguration
//@EnableJpaRepositories
//@ComponentScan
//@EnableAutoConfiguration
@SpringBootApplication
public class Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args)  {
        SpringApplication.run(Application.class, args);
//        new SpringApplicationBuilder(Application.class)
//                .bannerMode(Banner.Mode.CONSOLE)
//                .run(args);
    }

}
