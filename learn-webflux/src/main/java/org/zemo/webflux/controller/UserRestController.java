package org.zemo.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.zemo.webflux.domain.User;
import org.zemo.webflux.service.UserService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * @ClassName: UserRestController
 * @author: superzemo
 * @email: zeming.chen@dmall.com
 * @Date 2019-08-26
 * @Description
 */
@RestController
@RequestMapping("/api/user")
public class UserRestController {
    @Autowired
    private UserService userService;

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource not found")
    @ExceptionHandler(ResourceNotFoundException.class)
    public void notFound(){}


    @GetMapping("/list")
    public Flux<User> list() {
        return this.userService.list();
    }

    @GetMapping("/{id}")
    public Mono<User> getById(@PathVariable("id") final Long id) {
        return this.userService.getById(id);
    }

    @PostMapping("/save")
    public Mono<User> create(@RequestBody final User user) {
        return this.userService.createOrUpdate(user);
    }

    @PostMapping("/update/{id}")
    public Mono<User>  update(@PathVariable("id") final Long id, @RequestBody final User user) {
        Objects.requireNonNull(user);
        user.setId(id);
        return this.userService.createOrUpdate(user);
    }

    @PostMapping("/del/{id}")
    public Mono<User>  delete(@PathVariable("id") final Long id) {
        return this.userService.delete(id);
    }
}
