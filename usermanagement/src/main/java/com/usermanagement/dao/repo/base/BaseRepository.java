package com.usermanagement.dao.repo.base;

import com.usermanagement.dao.entity.Person;
import com.usermanagement.dao.entity.base.BaseEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity, PK extends Serializable> extends MongoRepository<T, PK>{

    void deleteByIdentifier(String identifier);

    Optional<Person> findByIdentifier(String identifier);

}