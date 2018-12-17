package com.metro.subterraneo.entity;

import java.util.List;

import com.metro.subterraneo.model.Node;

public class PathResponse {

	private List<Node> path;
	private double weight;
	
	public PathResponse(List<Node> path, double weight) {
		super();
		this.path = path;
		this.weight = weight;
	}
	public List<Node> getPaht() {
		return path;
	}
	public void setPaht(List<Node> path) {
		this.path = path;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	
}
