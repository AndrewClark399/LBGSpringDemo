package com.lbg.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.demo.domain.Country;
import com.lbg.demo.repos.CountryRepo;

@Service
public class CountryService {

	private CountryRepo repo;

	public CountryService(CountryRepo repo) {
		super();
		this.repo = repo;
	}

	// Create
	public Country create(Country newCountry) {
		return this.repo.save(newCountry);
	}

	// Read All
	public List<Country> getAll() {
		return this.repo.findAll();
	}

	// Read By Id
	public ResponseEntity<Country> getById(int id) {
		Optional<Country> found = this.repo.findById(id);
		if (found.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		Country body = found.get();
		return ResponseEntity.ok(body);
	}

	// Update By Id
	public ResponseEntity<Country> updateById(int id, Country newCountry) {
		Optional<Country> found = this.repo.findById(id);
		if (found.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Country existing = found.get();
		existing.setName(newCountry.getName());
		existing.setContinent(newCountry.getContinent());

		Country body = this.repo.save(existing);
		return ResponseEntity.ok(body);
	}

	// Delete By Id
	public boolean delete(int id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);

	}

}
