package test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Web application configuration
 * 
 */

@Configuration
@EnableWebMvc
@ComponentScan({ "test.service", "test.controller" })
public class WebAppConfig extends WebMvcConfigurerAdapter {

}
