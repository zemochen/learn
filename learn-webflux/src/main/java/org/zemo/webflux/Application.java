package org.zemo.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName: Application
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 24/11/2016 19:10
 * @Description ${TODO}
 */
@SpringBootApplication
@ComponentScan("org.zemo")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
