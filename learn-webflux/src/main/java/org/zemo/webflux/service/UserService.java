package org.zemo.webflux.service;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.zemo.webflux.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName: UserService
 * @author: superzemo
 * @email: zeming.chen@dmall.com
 * @Date 2019-08-26
 * @Description
 */
@Service
public class UserService {
    private final Map<Long, User> data = new ConcurrentHashMap<>();

    public Flux<User> list() {
        return Flux.fromIterable(this.data.values());
    }

    public Flux<User> getById(final Flux<Long> ids) {
        return ids.flatMap(id -> Mono.justOrEmpty(this.data.get(id)));
    }

    public Mono<User> getById(final Long id) {
        return Mono.justOrEmpty(this.data.get(id))
                .switchIfEmpty(Mono.error(new ResourceNotFoundException()));
    }

    public Mono<User> createOrUpdate(final User user) {
        this.data.put(user.getId(), user);
        return Mono.just(user);
    }

    public Mono<User> delete(final Long id) {
        return Mono.justOrEmpty(this.data.remove(id));
    }
}
