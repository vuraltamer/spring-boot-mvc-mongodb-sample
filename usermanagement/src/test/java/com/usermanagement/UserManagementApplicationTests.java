package com.usermanagement;

import com.usermanagement.dao.entity.Person;
import com.usermanagement.dao.repo.PersonRepository;
import com.usermanagement.services.PersonService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserManagementApplicationTests {

	@InjectMocks
	private PersonService service;

	@Mock
	private PersonRepository repository;

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

		when(repository.save(person)).thenReturn(sPerson);
		Assert.assertEquals(service.save(person).getUsername(), sPerson.getUsername());
	}

	public void PersonUpdate() {

		Person person = Mockito.mock(Person.class);
		Person sPerson = Mockito.mock(Person.class);

		when(repository.save(person)).thenReturn(sPerson);
		Assert.assertEquals(service.update(person).getUsername(), sPerson.getUsername());
	}

	public void PersonDelete() {

		Person person = Mockito.mock(Person.class);
		Person sPerson = Mockito.mock(Person.class);

		when(person.getIdentifier()).thenReturn("0");
		when(sPerson.getIdentifier()).thenReturn("0");

		Mockito.doNothing().
				doThrow(new RuntimeException())
				.when(repository).delete(person);
		Assert.assertEquals(service.delete(person.getIdentifier()), sPerson.getIdentifier());
	}

}
