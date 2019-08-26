package org.zemo.webflux.domain;

/**
 * @ClassName: User
 * @author: superzemo
 * @email: zeming.chen@dmall.com
 * @Date 2019-08-26
 * @Description
 */
public class User {
    private Long id;
    private String name;
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
