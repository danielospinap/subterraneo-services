package com.metro.subterraneo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.jgrapht.*;
import org.jgrapht.alg.shortestpath.BhandariKDisjointShortestPaths;
import org.jgrapht.alg.shortestpath.KShortestSimplePaths;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import com.metro.subterraneo.entity.EdgeResponse;
import com.metro.subterraneo.entity.MapResponse;
import com.metro.subterraneo.entity.PathResponse;
import com.metro.subterraneo.model.*;
import com.metro.subterraneo.repository.EdgeRepository;
import com.metro.subterraneo.repository.NodeRepository;
import com.metro.subterraneo.repository.RouteRepository;
import com.metro.subterraneo.repository.StationRepository;

 

@Service("pathService")
public class PathService {
	private EdgeRepository edgeRepository;
	private RouteRepository routeRepository;
	private NodeRepository nodeRepository;
	private StationRepository stationRepository;
	
	private List<Edge> edges;
	private List<Station> stations;
	private List<Node> nodes;
	
	@Autowired
	public PathService(
			EdgeRepository edgeRepository,
			RouteRepository routeRepository,
			NodeRepository nodeRepository,
			StationRepository stationRepository) {
		this.edgeRepository = edgeRepository;
		this.routeRepository = routeRepository;
		this.nodeRepository = nodeRepository;
		this.stationRepository = stationRepository;
		
		this.edges = edgeRepository.findAll();
		this.stations = stationRepository.findAll();
		this.nodes = nodeRepository.findAll();
	}
	
	public List<Station> findAllStations() {
		return this.stations;
	}
	
	
	public List<PathResponse> findShortestPath(String fromStation, String toStation, int maxNumberOfPaths) {
		
		Graph<Node, DefaultWeightedEdge> routesMap = this.createMap(this.nodes, this.edges);
				
		Node fromNode = this.findDefaultNode(routesMap, fromStation);
		Node toNode = this.findDefaultNode(routesMap, toStation);
		
		KShortestSimplePaths<Node, DefaultWeightedEdge> shortestPathCalculator = new KShortestSimplePaths<>(routesMap);
		List<GraphPath<Node, DefaultWeightedEdge>> paths = shortestPathCalculator.getPaths(fromNode, toNode, maxNumberOfPaths);
		
		return this.simplifyShortestPathsData(paths);
	}
	
	//Create a graph of the library jgrapht with the data of the map
	public Graph<Node, DefaultWeightedEdge> createMap(List<Node> nodes, List<Edge> edges) {
		
		Graph<Node, DefaultWeightedEdge> routesMap = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		for(Node node: nodes) {
			routesMap.addVertex(node);
		}
		
		for (Edge edge : edges) {
			Node nodeA = new Node();
			Node nodeB = new Node();
			for(int j = 0; j < this.nodes.size(); j ++) {
				if(nodes.get(j).getId() == edge.getNodeA().getId()) {
					nodeA = nodes.get(j);
				} else if(nodes.get(j).getId() == edge.getNodeB().getId()) {
					nodeB = nodes.get(j);
				} 
			}
			DefaultWeightedEdge weightedEdge = routesMap.addEdge(nodeA, nodeB);
			routesMap.setEdgeWeight(weightedEdge, edge.getWeight());
		}
		
		return routesMap;
	}
	
	//Find the node with route "DEFAULT" in a given graph from a given name.
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
	
	//Save data in a object that could be transformed in json
	public List<PathResponse> simplifyShortestPathsData(List<GraphPath<Node,DefaultWeightedEdge>> graphPaths) {
		List<PathResponse> pathsForResponse = new ArrayList<PathResponse>();
		for (int i = 0; i < graphPaths.size(); i++) {
			List<Node> path = graphPaths.get(i).getVertexList();
			path = this.removeRepeatedStations(path);
			//Subtract 2 minutes because of the way the data is represented
			double weight = graphPaths.get(i).getWeight() - 2;
			
			pathsForResponse.add(new PathResponse(path, weight));
		}
		
		return pathsForResponse;
	}
	
	//Removes Nodes with repeated stations
	public List<Node> removeRepeatedStations(List<Node> path) {

		List<Node> cleanedPath = new ArrayList<Node>();
		
		for(int i = 0; i < path.size()-1; i++) {
			if(path.get(i+1) != null) {
				if(path.get(i).getStation().getId() != path.get(i+1).getStation().getId()) {
					cleanedPath.add(path.get(i));
				}
			}
		}
		
		cleanedPath.add(path.get(path.size()-1));
		
		return cleanedPath;
	}
	
	
	public MapResponse getFullMap() {
		MapResponse map = new MapResponse();
		map.setStations(this.stations);
		
		map.setEdges(this.ConvertEdgesintoEdgesResponse(this.edges));
		
		return map;
	}
	
	public List<EdgeResponse> ConvertEdgesintoEdgesResponse(List<Edge> edges) {
		List<EdgeResponse> newEdges = new ArrayList<EdgeResponse>();
		
		for (Edge edge : edges) {
			if(edge.getNodeA().getRoute().getId() != 0 && edge.getNodeB().getId() != 0) {
				newEdges.add(new EdgeResponse(
						edge.getNodeA().getStation().getPosX(), 
						edge.getNodeA().getStation().getPosY(),
						edge.getNodeB().getStation().getPosX(), 
						edge.getNodeB().getStation().getPosY(), 
						edge.getNodeA().getRoute().getColor()));
			}
			
		}
		
		return newEdges;
	}
}
