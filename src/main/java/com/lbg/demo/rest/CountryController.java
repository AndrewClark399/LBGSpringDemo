package com.lbg.demo.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.demo.Services.CountryService;
import com.lbg.demo.domain.Country;

@RestController
@RequestMapping("/country/")
public class CountryController {

	private CountryService service;

	public CountryController(CountryService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public Country create(@RequestBody Country newCountry) {
		return this.service.create(newCountry);

	}

	@GetMapping("/get")
	public List<Country> getAll() {
		return this.service.getAll();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Country> getById(@PathVariable int id) {
		return this.service.getById(id);
	}

	@DeleteMapping("/delete/{id}")
	public Boolean delete(@PathVariable int id) {
		return this.service.delete(id);

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Country> updateById(@PathVariable int id, @RequestBody Country newCountry) {
		return this.service.updateById(id, newCountry);

	}

}
