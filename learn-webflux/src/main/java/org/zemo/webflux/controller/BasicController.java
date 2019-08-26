package org.zemo.webflux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @ClassName: BasicController
 * @author: superzemo
 * @email: zeming.chen@dmall.com
 * @Date 2019-08-26
 * @Description
 */
@RestController
public class BasicController {
    @GetMapping("/index")
    public Mono<String> sayHelloWorld() {
        return Mono.just("Hello Webflux World");
    }
}
