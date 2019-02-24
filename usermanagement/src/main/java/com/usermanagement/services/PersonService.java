package com.usermanagement.services;

import com.usermanagement.dao.entity.Person;
import com.usermanagement.dao.repo.PersonRepository;
import com.usermanagement.dao.repo.base.BaseRepository;
import com.usermanagement.services.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService extends BaseService<Person, String> {

    @Autowired
    public PersonRepository repository;

    @Override
    public BaseRepository<Person, String> getRepository() {
        return repository;
    }

}