package com.metro.subterraneo.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@IdClass(Node.class)
@Table(name = "node")
public class Node implements Serializable {

	@Id
	@ManyToOne
	@NotEmpty(message = "Please provide a route")
	private Route route;
	
	@Id
	@ManyToOne
	@NotEmpty(message = "Please provide a station")
	private Station station;
	
	public Node (
			@NotEmpty(message = "Please provide a route") Route route,
			@NotEmpty(message = "Please provide a station") Station station
			) {
		super();
		this.station = station;
		this.route = route;
	}
	
	public Node () {
		super();
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

	
}
