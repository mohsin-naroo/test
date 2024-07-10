package com.redmath.training.lecture04.user;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserDataService {

    private final JdbcTemplate jdbcTemplate;

    @edu.umd.cs.findbugs.annotations.SuppressFBWarnings(value = "EI_EXPOSE_REP2",
            justification = "spring managed bean modifications are acceptable")
    public UserDataService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public User findByUserName(String username) {
        return jdbcTemplate.queryForObject("select * from users where username = ?", User.class, username);
    }
}
