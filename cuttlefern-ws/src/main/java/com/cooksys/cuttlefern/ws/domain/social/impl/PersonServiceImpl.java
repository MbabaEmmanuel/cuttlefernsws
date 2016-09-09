package com.cooksys.cuttlefern.ws.domain.social.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.cuttlefern.ws.domain.social.Person;
import com.cooksys.cuttlefern.ws.domain.social.PersonRepository;
import com.cooksys.cuttlefern.ws.domain.social.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	private final PersonRepository repo;

	@Autowired
	public PersonServiceImpl(PersonRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Person create(Person person) {
		return this.repo.saveAndFlush(person);
	}

	@Override
	public List<Person> index() {
		return this.repo.findAll();
	}

	@Override
	public Person read(Integer id) {
		return this.repo.findOne(id);
	}

	@Override
	public Person update(Integer id, Person personToUpdate) {
		personToUpdate.setId(id);
		return this.repo.saveAndFlush(personToUpdate);
	}

	@Override
	public Person delete(Integer id) {
		Person result = this.read(id);
		this.repo.delete(id);
		return result;
	}
	
}
