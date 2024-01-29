package com.lbg.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lbg.demo.domain.Country;

@Repository
public interface CountryRepo extends JpaRepository<Country, Integer> {

}
