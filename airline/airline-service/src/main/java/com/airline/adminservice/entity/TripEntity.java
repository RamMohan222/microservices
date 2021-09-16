package com.airline.adminservice.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "trip")
public class TripEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tripId;
	private String fromLocation;
	private String toLocation;
	private int cost;

	@OneToMany(mappedBy = "trip", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<AeroplaneEntity> aeroplane = new ArrayList<>();

	public int getTripId() {
		return tripId;
	}

	public void setTripId(int tripId) {
		this.tripId = tripId;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public List<AeroplaneEntity> getAeroplane() {
		return aeroplane;
	}

	public void setAeroplane(List<AeroplaneEntity> aeroplane) {
		this.aeroplane = aeroplane;
	}

}
