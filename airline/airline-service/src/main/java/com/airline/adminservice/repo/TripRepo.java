package com.airline.adminservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.airline.adminservice.entity.TripEntity;

public interface TripRepo extends JpaRepository<TripEntity, Integer> {

	@Query("select t from TripEntity t where t.fromLocation=:from OR t.toLocation=:to OR t.tripId=:id")
	List<TripEntity> findByFromAndToOrId(@Param("from") String from, @Param("to") String to, @Param("id") Integer id);
}
