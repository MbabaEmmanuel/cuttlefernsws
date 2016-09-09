package com.cooksys.cuttlefern.ws.domain.social.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.cuttlefern.ws.domain.social.Group;
import com.cooksys.cuttlefern.ws.domain.social.GroupRepository;
import com.cooksys.cuttlefern.ws.domain.social.GroupService;

@Service
public class GroupServiceImpl implements GroupService {
	
	private final GroupRepository repo;
	
	@Autowired
	public GroupServiceImpl(GroupRepository repo) {
		super();
		this.repo = repo;
	}
	
	@Override
	public List<Group> index() {
		return this.repo.findAll();
	}
	
	@Override
	public Group read(Integer id) {
		return this.repo.findOne(id);
	}

	@Override
	public Group delete(Integer id) {
		Group result = this.read(id);
		this.repo.delete(id);
		return result;
	}

	@Override
	public Group update(Integer id, Group groupToUpdate) {
		groupToUpdate.setId(id);
		return this.repo.saveAndFlush(groupToUpdate);
	}

	

	

	@Override
	public Group create(Group group) {
		return this.repo.saveAndFlush(group);
	}
}
