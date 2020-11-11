//package com.wowotou.common;
//
//import org.springframework.data.mongodb.MongoDbFactory;
//import org.springframework.data.mongodb.core.MongoTemplate;
//
//
//public abstract class AbstractMongoConfig {
//    private String uri;
//
//    /*
//     * Method that creates MongoDbFactory Common to both of the MongoDb
//     * connections
//     */
//    public MongoDbFactory mongoDbFactory() throws Exception {
//
//        return new SimpleMongoDbFactory(new MongoClientURI(uri));
//    }
//
//    /*
//     * Factory method to create the MongoTemplate
//     */
//    abstract public MongoTemplate getMongoTemplate() throws Exception;
//}
