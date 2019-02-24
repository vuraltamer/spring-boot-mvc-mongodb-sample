package com.usermanagement;

import com.usermanagement.dao.entity.Person;
import com.usermanagement.services.PersonService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserManagementApplicationTests {

	@InjectMocks
	private PersonService service;

	@Mock
	private MongoTemplate mongoTemplate;

	@Test
	public void contextLoads() {
		PersonSave();
		PersonUpdate();
		PersonDelete();
	}

	/**
	 * Code coverage is completed.
	 *
	 */
	public void PersonSave() {

		Person person = Mockito.mock(Person.class);
		Person sPerson = Mockito.mock(Person.class);

		Mockito.when(mongoTemplate.save(person)).thenReturn(sPerson);
		Assert.assertEquals(service.save(person).getUsername(), sPerson.getUsername());
	}

	public void PersonUpdate() {

		Person person = Mockito.mock(Person.class);
		Person sPerson = Mockito.mock(Person.class);

		Mockito.when(mongoTemplate.save(person)).thenReturn(sPerson);
		Assert.assertEquals(service.update(person).getUsername(), sPerson.getUsername());
	}

	public void PersonDelete() {

		Person person = Mockito.mock(Person.class);
		Person sPerson = Mockito.mock(Person.class);

		Assert.assertEquals(service.delete(person.getIdentifier()), sPerson.getIdentifier());
	}

}
