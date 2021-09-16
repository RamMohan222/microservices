package com.airline.adminservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airline.adminservice.entity.AeroplaneEntity;
import com.airline.adminservice.entity.TripEntity;
import com.airline.adminservice.repo.AeroplaneRepo;
import com.airline.adminservice.repo.TripRepo;

@RestController
@RequestMapping("/admin")
public class AdminAriLineController {

	@Autowired
	private AeroplaneRepo aeroplaneRepo;

	@Autowired
	private TripRepo tripRepo;

	@PostMapping("/save-aeroplane")
	public ResponseEntity<AeroplaneEntity> saveAeroplance(AeroplaneEntity aeroplane) {
		aeroplane = aeroplaneRepo.save(aeroplane);
		return new ResponseEntity<>(aeroplane, HttpStatus.CREATED);
	}

	@PostMapping("/save-trip")
	public ResponseEntity<TripEntity> saveTrip(TripEntity trip) {
		trip = tripRepo.save(trip);
		return new ResponseEntity<>(trip, HttpStatus.CREATED);
	}
}
