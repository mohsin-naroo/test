package com.redmath.training.lecture04.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ConfigurationProperties(prefix = "api.security")
public class ApiProperties {

    private String ignored;
}
