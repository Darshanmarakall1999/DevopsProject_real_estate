package com.thbs.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thbs.models.house;

public interface HouseRepository extends JpaRepository<house,Integer> {

}
