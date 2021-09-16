package com.airline.adminservice;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.airline.adminservice.entity.AeroplaneEntity;
import com.airline.adminservice.entity.TripEntity;
import com.airline.adminservice.repo.AeroplaneRepo;
import com.airline.adminservice.repo.TripRepo;

@EnableEurekaClient
@SpringBootApplication
@EnableTransactionManagement
public class AirlineServiceApplication {

	@Autowired
	private AeroplaneRepo aeroplaneRepo;

	@Autowired
	private TripRepo tripRepo;

	public static void main(String[] args) {
		SpringApplication.run(AirlineServiceApplication.class, args);
	}

	@PostConstruct
	@Transactional
	public void init() {

		TripEntity trip = new TripEntity();
		trip.setFromLocation("Hyderabad");
		trip.setToLocation("Delhi");
		trip.setCost(3000);

		tripRepo.save(trip);
		
		AeroplaneEntity a1 = new AeroplaneEntity("KingFisher1", 100);
		AeroplaneEntity a2 = new AeroplaneEntity("KingFisher1", 100);
		a1.setTrip(trip);
		a2.setTrip(trip);
		
		trip.getAeroplane().add(a1);
		trip.getAeroplane().add(a2);
		
		aeroplaneRepo.save(a1);
		aeroplaneRepo.save(a2);

		tripRepo.findByFromAndToOrId(trip.getFromLocation(), trip.getToLocation(), 0);
	}

}
