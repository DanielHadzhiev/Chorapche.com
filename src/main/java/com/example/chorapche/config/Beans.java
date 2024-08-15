package com.example.chorapche.config;

import com.example.chorapche.session.CurrentOrder;
import com.example.chorapche.utils.FormatUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;


@Configuration
public class Beans {

    @Bean
    @Scope(WebApplicationContext.SCOPE_SESSION)
    public CurrentOrder orderSession() {
        return new CurrentOrder();
    }

    @Bean
    public FormatUtils formatUtils() {
        return new FormatUtils();
    }

}
