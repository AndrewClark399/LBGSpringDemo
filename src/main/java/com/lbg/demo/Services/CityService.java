package com.lbg.demo.Services;

//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.demo.domain.City;
import com.lbg.demo.repos.CityRepo;

@Service
public class CityService {

	// OLD private List<City> cities = new ArrayList<>();

	private CityRepo repo;

	public CityService(CityRepo repo) {
		super();
		this.repo = repo;
	}

//Create new Entry
	public ResponseEntity<City> createCity(City newCity) {
		// OLD this.cities.add(newCity);
		// OLD returns the last element in the list
		// OLD City body = this.cities.get(this.cities.size() - 1);

		City created = this.repo.save(newCity);

		return new ResponseEntity<City>(created, HttpStatus.CREATED);
	}

//Show all Entries
	public List<City> getCities() {
		return this.repo.findAll();
	}

//Show a specific Entry
	public ResponseEntity<City> getCity(int id) {
		Optional<City> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<City>(HttpStatus.NOT_FOUND);
		}
		City body = found.get();
		return ResponseEntity.ok(body);
	}

//Replace an Entry
	public ResponseEntity<City> updateCity(int id, City newCity) {
		Optional<City> found = this.repo.findById(id);
		if (found.isEmpty()) {
			return new ResponseEntity<City>(HttpStatus.NOT_FOUND);
		}

		City existing = found.get();
		if (newCity.getName() != null) {
			existing.setName(newCity.getName());
		}

		if (newCity.getCounty() != null) {
			existing.setCounty(newCity.getCounty());
		}
		City updated = this.repo.save(existing);
		return ResponseEntity.ok(updated);
	}

//Delete an Entry
	public boolean remove(int id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}
