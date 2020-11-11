package com.wowotou.dao;


import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mapping.MappingException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.MongoPersistentEntity;
import org.springframework.data.mongodb.core.mapping.MongoPersistentProperty;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/***
 @Author:MrHuang
 @Date: 2019/9/4 16:19
 @DESC: TODO
 @VERSION: 1.0
 ***/
@Repository
public class MongoDao<T> {

    @Resource
    private MongoTemplate mongoTemplate;

    public T insert(T t) {
        return  mongoTemplate.insert(t);
    }

    public DeleteResult delete(T t) {
        return mongoTemplate.remove(t);
    }

    public DeleteResult deleteById(Object id) {
        T t = mongoTemplate.findById(id, getTClass());
        return delete(t);
    }

    public DeleteResult delete(Query query) {
        return mongoTemplate.remove(query, getTClass());
    }

    public T update(T t) {
       return  mongoTemplate.save(t);

    }

    public T findById(Object id) {
        return mongoTemplate.findById(id, getTClass());
    }

    public List<T> findAll() {
        return mongoTemplate.findAll(getTClass());
    }

    public List<T> find(Query query) {

        return mongoTemplate.find(query, getTClass());
    }
    public  T findOne(Query query) {
        List<T> ts = mongoTemplate.find(query, getTClass());
        if (!ts.isEmpty()&&ts.size()>0){
            return ts.stream().findFirst().get();
        }
        return  null;
    }

    public boolean exists(Query query) {
        return mongoTemplate.exists(query, getTClass());
    }

    public boolean exists(T t) {
        return exists(getIdQueryFor(t));
    }

    public boolean exitsById(Object id) {
        return exists(findById(id));
    }

    public long count(Query query) {
        return mongoTemplate.count(query, getTClass());
    }

    private Class<T> getTClass() {
        Class<T> tClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return tClass;
    }

    private Pair<String, Object> extractIdPropertyAndValue(Object object) {
        Assert.notNull(object, "Id cannot be extracted from 'null'.");
        Class<?> objectType = object.getClass();
        if (object instanceof Document) {
            return Pair.of("_id", ((Document) object).get("_id"));
        } else {
            MongoPersistentEntity<?> entity = (MongoPersistentEntity) mongoTemplate.getConverter().getMappingContext().getPersistentEntity(objectType);
            if (entity != null && entity.hasIdProperty()) {
                MongoPersistentProperty idProperty = (MongoPersistentProperty) entity.getIdProperty();
                return Pair.of(idProperty.getFieldName(), entity.getPropertyAccessor(object).getProperty(idProperty));
            } else {
                throw new MappingException("No id property found for object of type " + objectType);
            }
        }
    }

    private Query getIdQueryFor(Object object) {
        Pair<String, Object> id = this.extractIdPropertyAndValue(object);
        return new Query(Criteria.where((String) id.getFirst()).is(id.getSecond()));
    }


}


