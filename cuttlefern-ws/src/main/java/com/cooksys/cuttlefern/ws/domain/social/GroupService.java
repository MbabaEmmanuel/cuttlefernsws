package com.cooksys.cuttlefern.ws.domain.social;

import java.util.List;

public interface GroupService {

	Group delete(Integer id);

	Group update(Integer id, Group groupToUpdate);

	Group read(Integer id);

	List<Group> index();

	Group create(Group group);

}
