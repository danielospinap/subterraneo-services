package com.metro.subterraneo.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "edge")
public class Edge {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "edge_id")
	private int id;
	
	@ManyToOne
	@NotEmpty(message = "Please provide a node")
	private Node nodeA;
	
	@ManyToOne
	@NotEmpty(message = "Please provide a node")
	private Node nodeB;
	
	@Column
	private double weight;
	
	public Edge (
			int id,
			@NotEmpty(message = "Please provide a node") Node nodeA,
			@NotEmpty(message = "Please provide a node") Node nodeB,
			double weight
			) {
		super();
		this.id = id;
		this.nodeA = nodeA;
		this.nodeB = nodeB;
		this.weight = weight;
	}
	
	public Edge () {
		super();
	}

	public Node getNodeA() {
		return nodeA;
	}

	public void setNodeA(Node nodeA) {
		this.nodeA = nodeA;
	}

	public Node getNodeB() {
		return nodeB;
	}

	public void setNodeB(Node nodeB) {
		this.nodeB = nodeB;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	

}
