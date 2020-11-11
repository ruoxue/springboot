package com.wowotou.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Configuration
@ConfigurationProperties(prefix = "spring.data.mongodb.")
@Component
public class CommunityMongoConfig extends AbstractMongoConfig {


    @Primary
    @Bean(name = "template1")
    @Override
    public MongoTemplate getMongoTemplate() throws Exception {
        return new MongoTemplate(mongoDbFactory());
    }

}
