package com.lbg.demo.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.demo.Services.CityService;
import com.lbg.demo.domain.City;

@RestController
@RequestMapping("/city/")
public class CityController {
	// List no longer required when using database
	// private List<City> cities = new ArrayList<>();

	private CityService service;

	public CityController(CityService service) {
		super();
		this.service = service;
	}

	@GetMapping("/hello")
	public String greet() {
		return ("Hello, World!");
	}

	@PostMapping("/create")
	public ResponseEntity<City> createCity(@RequestBody City newCity) {
		return this.service.createCity(newCity);

	}

	@GetMapping("/get")
	public List<City> getCities() {
		return this.service.getCities();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<City> getCity(@PathVariable int id) {
		return this.service.getCity(id);
	}

	@DeleteMapping("/delete/{id}")
	public Boolean removeCity(@PathVariable int id) {
		return this.service.remove(id);

	}

	@PatchMapping("/update/{id}")
	public ResponseEntity<City> updateCity(@PathVariable int id, @RequestBody City newCity) {
		return this.service.updateCity(id, newCity);

	}
}
