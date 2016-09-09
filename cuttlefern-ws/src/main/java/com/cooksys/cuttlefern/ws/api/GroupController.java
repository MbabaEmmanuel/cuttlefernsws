package com.cooksys.cuttlefern.ws.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.cuttlefern.ws.domain.social.Group;
import com.cooksys.cuttlefern.ws.domain.social.GroupService;

@RestController
@RequestMapping("api/group")
public class GroupController {
private final GroupService service;
	
	@Autowired
	public GroupController(GroupService service) {
		super();
		this.service = service;
	}

	@RequestMapping(method=RequestMethod.POST)
	public Group create(@RequestBody Group Group) {
		return this.service.create(Group);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Group> index() {
		return this.service.index();
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public Group read(@PathVariable Integer id) {
		return this.service.read(id);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.PATCH) // Return old and new Group, or just old Group
	public Group update(@PathVariable Integer id, @RequestBody Group GroupToUpdate) {
		return this.service.update(id, GroupToUpdate);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.DELETE) // Return old and new Group, or just old Group
	public Group delete(@PathVariable Integer id) {
		return this.service.delete(id);
	} 
	

}
