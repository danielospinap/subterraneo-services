package com.metro.subterraneo.controller;

import java.util.ArrayList;
import java.util.List;

import org.jgrapht.GraphPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metro.subterraneo.entity.PathResponse;
import com.metro.subterraneo.model.Edge;
import com.metro.subterraneo.model.Node;
import com.metro.subterraneo.model.Route;
import com.metro.subterraneo.model.Station;
import com.metro.subterraneo.service.PathService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping
public class GraphRestController {
	
	@Autowired
	private PathService pathService;

	@GetMapping(value= "/{from}/{to}/{numberOfPaths}")
	public ResponseEntity<List<PathResponse>> paths(@PathVariable String from, @PathVariable String to, @PathVariable int numberOfPaths) {
		List<PathResponse> paths = this.pathService.findShortestPath(from, to, numberOfPaths);
		return new ResponseEntity<List<PathResponse>>(paths, HttpStatus.OK);
	}
	
	@GetMapping("/stations")
	public List<Station> allStations() {
		return this.pathService.findAllStations();
	}
}
