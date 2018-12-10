package com.metro.subterraneo.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "node")
public class Node {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "node_id")
	private int id;
	
	@ManyToOne
	@NotEmpty(message = "Please provide a route")
	private Route route;
	
	@ManyToOne
	@NotEmpty(message = "Please provide a station")
	private Station station;
	
	public Node (
			int id,
			@NotEmpty(message = "Please provide a route") Route route,
			@NotEmpty(message = "Please provide a station") Station station
			) {
		super();
		this.id = id;
		this.station = station;
		this.route = route;
	}
	
	public Node () {
		
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
