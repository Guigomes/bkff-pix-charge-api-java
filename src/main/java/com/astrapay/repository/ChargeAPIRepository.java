package com.astrapay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.astrapay.model.ChargeAPI;

@Repository
public interface ChargeAPIRepository extends JpaRepository<ChargeAPI, Integer> {

	
}
