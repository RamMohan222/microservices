package com.airline.adminservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airline.adminservice.entity.AeroplaneEntity;

public interface AeroplaneRepo extends JpaRepository<AeroplaneEntity, Integer> {

}
