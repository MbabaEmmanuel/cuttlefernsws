package com.cooksys.cuttlefern.ws.domain.social;

import java.util.List;

public interface PersonService {

	Person create(Person person);

	List<Person> index();

	Person read(Integer id);

	Person update(Integer id, Person personToUpdate);

	Person delete(Integer id);

}
