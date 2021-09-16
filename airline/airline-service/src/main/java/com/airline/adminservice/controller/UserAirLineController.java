package com.airline.adminservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.airline.adminservice.entity.AeroplaneEntity;
import com.airline.adminservice.entity.BookingEntity;
import com.airline.adminservice.entity.TripEntity;
import com.airline.adminservice.entity.UserEntity;
import com.airline.adminservice.repo.AeroplaneRepo;
import com.airline.adminservice.repo.BookingRepo;
import com.airline.adminservice.repo.TripRepo;
import com.airline.adminservice.repo.UserRepo;

@RestController
@RequestMapping("/user")
public class UserAirLineController {

	@Autowired
	private TripRepo tripsRepo;
	@Autowired
	private BookingRepo bookingRepo;
	@Autowired
	private AeroplaneRepo aeroplaneRepo;
	@Autowired
	private UserRepo userRepo;

	@PostMapping("/login")
	public ResponseEntity<UserEntity> login(UserEntity user) {
		user = userRepo.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		if(user == null) {
			return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PostMapping("/register")
	public ResponseEntity<UserEntity> registerUser(UserEntity user) {
		user = userRepo.save(user);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

	@GetMapping("/all-trips")
	public List<TripEntity> getAllTrips() {
		return tripsRepo.findAll();
	}

	@GetMapping("/all-aeroplanes")
	public List<AeroplaneEntity> getAllPlains() {
		return aeroplaneRepo.findAll();
	}

	@GetMapping("/search-trips")
	public List<TripEntity> getAllTrips(@RequestParam(required = false) String from,
			@RequestParam(required = false) String to, @RequestParam(required = false) Integer tripId) {
		return tripsRepo.findByFromAndToOrId(from, to, tripId);
	}

	@PostMapping("/book")
	public BookingEntity saveBooking(BookingEntity booking) {
		return bookingRepo.save(booking);
	}

	@DeleteMapping("/cancel-booking")
	public ResponseEntity<Boolean> cancelBooking(Integer bookingId) {
		bookingRepo.deleteById(bookingId);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
}
