package com.metro.subterraneo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "query")
public class Query {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "query_id")
	private int id;
	
	@ManyToOne
	private Station originStation;
	
	@ManyToOne
	private Station destinationStation;
	
	@Column
	private int times;

	public Query(Station originStation, Station destinationStation, int times) {
		super();
		this.originStation = originStation;
		this.destinationStation = destinationStation;
		this.times = times;
	}

	public Query(Station originStation, Station destinationStation) {
		super();
		this.originStation = originStation;
		this.destinationStation = destinationStation;
		this.times = 0;
	}
	
	public Query() {
		super();
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Station getOriginStation() {
		return originStation;
	}

	public void setOriginStation(Station originStation) {
		this.originStation = originStation;
	}

	public Station getDestinationStation() {
		return destinationStation;
	}

	public void setDestinationStation(Station destinationStation) {
		this.destinationStation = destinationStation;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}
	
	
	
}
