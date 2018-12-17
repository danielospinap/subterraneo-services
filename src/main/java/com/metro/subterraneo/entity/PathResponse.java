package com.metro.subterraneo.entity;

import java.util.List;

import com.metro.subterraneo.model.Node;

public class PathResponse {

	private List<Node> path;
	private double time;
	
	public PathResponse(List<Node> path, double time) {
		super();
		this.path = path;
		this.time = time;
	}
	public List<Node> getPaht() {
		return path;
	}
	public void setPaht(List<Node> path) {
		this.path = path;
	}
	public double getWeight() {
		return time;
	}
	public void setWeight(double time) {
		this.time = time;
	}
	
	
}
