package com.cooksys.cuttlefern.ws.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.cuttlefern.ws.domain.location.City;
import com.cooksys.cuttlefern.ws.domain.location.CityService;
import com.cooksys.cuttlefern.ws.domain.location.State;

@RestController
@RequestMapping("api/city")
public class CityController {
	private final CityService service;
	
	@Autowired
	public CityController(CityService service) {
		super();
		this.service = service;
	}

	@RequestMapping(method=RequestMethod.POST)
	public List<City> create(@RequestBody List<City> list) {
		return this.service.create(list);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<City> index() {
		return this.service.index();
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public City read(@PathVariable Integer id) {
		return this.service.read(id);
	}
	
	@RequestMapping(value="{id}/state", method=RequestMethod.GET)
	public State readState(@PathVariable Integer id) {
		return this.service.readState(id);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.PATCH) 
	public City update(@PathVariable Integer id, @RequestBody City CityToUpdate) {
		return this.service.update(id, CityToUpdate);
	}
	
	@RequestMapping(value="{id}/state", method=RequestMethod.PATCH) 
	public City updateState(@PathVariable Integer id, @RequestBody State stateToUpdate) {
		return this.service.updateState(id, stateToUpdate);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.DELETE) // Return old and new City, or just old City
	public City delete(@PathVariable Integer id) {
		return this.service.delete(id);
	} 
	

}
