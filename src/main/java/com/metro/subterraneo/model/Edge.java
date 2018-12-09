package com.metro.subterraneo.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@IdClass(Edge.class)
@Table(name = "edge")
public class Edge implements Serializable {

	@Id
	@ManyToOne
	@Column(name = "node_a")
	@NotEmpty(message = "Please provide a node")
	private Node nodeA;
	
	@Id
	@ManyToOne
	@Column(name = "node_b")
	@NotEmpty(message = "Please provide a node")
	private Node nodeB;
	
	public Edge (
			@NotEmpty(message = "Please provide a node") Node nodeA,
			@NotEmpty(message = "Please provide a node") Node nodeB
			) {
		super();
		this.nodeA = nodeA;
		this.nodeB = nodeB;
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

	

}
