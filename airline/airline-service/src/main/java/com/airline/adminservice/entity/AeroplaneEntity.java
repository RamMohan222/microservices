package com.airline.adminservice.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "aeroplanes")
public class AeroplaneEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int aeroplaneId;
	private String name;
	private int capacity;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "trip_id", nullable = false)
	@JsonIgnore
	private TripEntity trip;

	public AeroplaneEntity() {
	}

	public AeroplaneEntity(String name, int capacity) {
		super();
		this.name = name;
		this.capacity = capacity;
	}

	public int getAeroplaneId() {
		return aeroplaneId;
	}

	public void setAeroplaneId(int aeroplaneId) {
		this.aeroplaneId = aeroplaneId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public TripEntity getTrip() {
		return trip;
	}

	public void setTrip(TripEntity trip) {
		this.trip = trip;
	}

}
