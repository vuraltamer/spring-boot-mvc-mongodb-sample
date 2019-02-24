package com.usermanagement.services.base;

import com.usermanagement.dao.entity.base.BaseEntity;
import com.usermanagement.dao.repo.base.BaseRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public abstract class BaseService<T extends BaseEntity, PK extends Serializable> {

    public static final Logger logger = LogManager.getLogger(BaseService.class);

    @Autowired
    MongoTemplate mongoTemplate;

    /*
    * Get BaseRepository
    *
    * */
    public abstract BaseRepository<T, PK> getRepository();

    /*
    * Save
    *
    * */
    @Transactional
    public T save(T entity) {
        entity.setIdentifier(UUID.randomUUID().toString());
        entity.setCreateDate(new Date());
        return mongoTemplate.save(entity);
    }

    /*
    * Update
    *
    * */
    @Transactional
    public T update(T entity) {
        entity.setUpdateDate(new Date());
        return mongoTemplate.save(entity);
    }


    /*
     * List All Table
     *
     * */
    public List<T> all() {
        return getRepository().findAll();
    }


    /*
     * Delete
     *
     * */
    public String delete(String id) {

        try {
            getRepository().deleteByIdentifier(id);
            return "0";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}