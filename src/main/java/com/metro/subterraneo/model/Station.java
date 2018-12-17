package com.metro.subterraneo.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "station")
public class Station {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "station_id")
	private int id;
	
	@Column(name = "name")
	@NotEmpty(message = "Please provide a name")
	private String name;

	@Column(name = "posX")
	private int posX;
	
	@Column(name = "posY")
	private int posY;
	
	public Station (
			int id,
			@NotEmpty(message = "Please provide a name") String name
			) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Station () {
		super();
	}
	
	public Station (
			@NotEmpty(message = "Please provide a name") String name
			) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	
}
