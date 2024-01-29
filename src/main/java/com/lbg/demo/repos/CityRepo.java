package com.lbg.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lbg.demo.domain.City;

@Repository
public interface CityRepo extends JpaRepository<City, Integer> {

}
