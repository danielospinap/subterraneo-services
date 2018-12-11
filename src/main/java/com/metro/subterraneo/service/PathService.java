package com.metro.subterraneo.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.jgrapht.*;
import org.jgrapht.alg.shortestpath.BhandariKDisjointShortestPaths;
import org.jgrapht.alg.shortestpath.KShortestSimplePaths;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import com.metro.subterraneo.model.*;
import com.metro.subterraneo.repository.EdgeRepository;
import com.metro.subterraneo.repository.NodeRepository;
import com.metro.subterraneo.repository.RouteRepository;

 

@Service("pathService")
public class PathService {
	private EdgeRepository edgeRepository;
	private RouteRepository routeRepository;
	private NodeRepository nodeRepository;
	
	@Autowired
	public PathService(
			EdgeRepository edgeRepository,
			RouteRepository routeRepository,
			NodeRepository nodeRepository) {
		this.edgeRepository = edgeRepository;
		this.routeRepository = routeRepository;
		this.nodeRepository = nodeRepository;
	}
	
	public List<Edge> findAllEdges() {
		return edgeRepository.findAll();
	}
	
	public List<Route> findAllRoutes() {
		return routeRepository.findAll();
	}
	
	public List<GraphPath<Node, DefaultWeightedEdge>> findShortestPath(String fromStation, String toStation, int maxNumberOfPaths) {
		List<Node> nodes = nodeRepository.findAll();
		List<Edge> edges = edgeRepository.findAll();
		
		Graph<Node, DefaultWeightedEdge> routesMap = this.createMap(nodes, edges);
				
		Node fromNode = this.findDefaultNode(routesMap, fromStation);
		Node toNode = this.findDefaultNode(routesMap, toStation);
		
		KShortestSimplePaths<Node, DefaultWeightedEdge> shortestPathCalculator = new KShortestSimplePaths<>(routesMap);
		return shortestPathCalculator.getPaths(fromNode, toNode, maxNumberOfPaths);
	}
	
	public Graph<Node, DefaultWeightedEdge> createMap(List<Node> nodes, List<Edge> edges) {
		
		Graph<Node, DefaultWeightedEdge> routesMap = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		for(Node node: nodes) {
			routesMap.addVertex(node);
		}
		
		for (Edge edge : edges) {
			DefaultWeightedEdge weightedEdge = routesMap.addEdge(edge.getNodeA(), edge.getNodeB());
			routesMap.setEdgeWeight(weightedEdge, edge.getWeight());
		}
		
		return routesMap;
	}
	
	public Node findDefaultNode(Graph<Node, DefaultWeightedEdge> routesMap, String stationName) {
		Node foundNode = null;
		Iterator<Node> vertices = routesMap.vertexSet().iterator();
		while(vertices.hasNext()) {
			Node node = vertices.next();
			if (node.getStation().getName().equals(stationName) && node.getRoute().getName().equals("DEFAULT")) {
				foundNode = node;
			}
		}
		
		return foundNode;
	}
}
