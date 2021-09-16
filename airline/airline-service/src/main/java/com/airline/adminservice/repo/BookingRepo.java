package com.airline.adminservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airline.adminservice.entity.BookingEntity;

public interface BookingRepo extends JpaRepository<BookingEntity, Integer> {

}
