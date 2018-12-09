package com.metro.subterraneo.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "route")
public class Route {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "route_id")
	private int id;
	
	@Column(name = "name")
	@NotEmpty(message = "Please provide a name")
	private String name;
	
	@Column(name = "color")
	@NotEmpty(message = "Please provide a color")
	private String color;
	
	public Route (
			int id,
			@NotEmpty(message = "Please provide a name") String name,
			@NotEmpty(message = "Please provide a color") String color
			) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
	}
	
	public Route () {
		super();
	}
	
	public Route (
			@NotEmpty(message = "Please provide a name") String name,
			@NotEmpty(message = "Please provide a color") String color
			) {
		super();
		this.name = name;
		this.color = color;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
}
