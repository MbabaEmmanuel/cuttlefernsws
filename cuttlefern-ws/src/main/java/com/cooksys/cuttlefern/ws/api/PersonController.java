package com.cooksys.cuttlefern.ws.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.cuttlefern.ws.domain.social.Person;
import com.cooksys.cuttlefern.ws.domain.social.PersonService;

@RestController
@RequestMapping("api/person")
public class PersonController {
private final PersonService service;
	
	@Autowired
	public PersonController(PersonService service) {
		super();
		this.service = service;
	}

	@RequestMapping(method=RequestMethod.POST)
	public Person create(@RequestBody Person Person) {
		return this.service.create(Person);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Person> index() {
		return this.service.index();
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public Person read(@PathVariable Integer id) {
		return this.service.read(id);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.PATCH) // Return old and new Person, or just old Person
	public Person update(@PathVariable Integer id, @RequestBody Person PersonToUpdate) {
		return this.service.update(id, PersonToUpdate);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.DELETE) // Return old and new Person, or just old Person
	public Person delete(@PathVariable Integer id) {
		return this.service.delete(id);
	} 

}
