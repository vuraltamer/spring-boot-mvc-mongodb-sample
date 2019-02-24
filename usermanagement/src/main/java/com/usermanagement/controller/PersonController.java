package com.usermanagement.controller;


import com.usermanagement.controller.base.BaseController;
import com.usermanagement.controller.dto.PersonDto;
import com.usermanagement.dao.entity.Person;
import com.usermanagement.dao.entity.base.BaseEntity;
import com.usermanagement.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("person")
public class PersonController extends BaseController<Person, PersonDto> {

    @Autowired
    private PersonService service;

    /*
    * http://localhost:8080/person/?id={id}
     * Find any user with identifier
     * Request Type : GET
     *
    * */
    @GetMapping("/")
    public ResponseEntity find(String id) {

        Optional<Person> person = service.getRepository().findByIdentifier(id);

        return createResponse((person.isPresent() ? person.get() : null), new PersonDto());
    }

    /*
     * http://localhost:8080/person/list
     * Find All User
     * Request Type : GET
     *
     * */
    @GetMapping("/list")
    public ResponseEntity list() {

        List<Person> findAll = service.all();

        return createResponse(findAll, new PersonDto());
    }

    /*
     * http://localhost:8080/person/save
     * Save user
     * Request Type : POST
     * Requirement : RequestBody
     *
     * */
    @PostMapping(value = "/save", produces = "application/json")
    public ResponseEntity save(@RequestBody @Valid PersonDto personDto) {

        final BaseEntity request = createRequest(new Person(), personDto);
        final Person save = service.save((Person) request);

        return ResponseEntity.ok(save);
    }

    /*
     * http://localhost:8080/person/update
     * Update any user
     * Request Type : POST
     * Requirement : RequestBody
     *
     * */
    @PostMapping(value = "/update", produces = "application/json")
    public ResponseEntity update(@RequestBody @Valid PersonDto personDto) {

        final BaseEntity request = createRequest(new Person(), personDto);
        final Person update = service.update((Person) request);

        return ResponseEntity.ok(update);
    }

    /*
     * http://localhost:8080/person/user
     * Delete any user with id
     * Request Type : GET
     *
     * */
    @GetMapping("/delete")
    public ResponseEntity delete(String id) {

        return ResponseEntity.ok(service.delete(id));
    }

}
