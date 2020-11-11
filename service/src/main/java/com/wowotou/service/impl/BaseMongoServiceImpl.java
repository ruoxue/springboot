package com.wowotou.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.MongoId;

public class BaseMongoServiceImpl {
    @Autowired
    public MongoTemplate mongoTemplate;

}
