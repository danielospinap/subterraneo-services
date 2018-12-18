package com.metro.subterraneo.entity;

import java.util.List;

import com.metro.subterraneo.model.Station;

public class MapResponse {

	private List<Station> stations;
	private List<EdgeResponse> edges;
	
	public MapResponse(List<Station> stations, List<EdgeResponse> edges) {
		super();
		this.stations = stations;
		this.edges = edges;
	}

	public MapResponse() {
		super();
	}
	

	public List<Station> getStations() {
		return stations;
	}

	public void setStations(List<Station> stations) {
		this.stations = stations;
	}

	public List<EdgeResponse> getEdges() {
		return edges;
	}

	public void setEdges(List<EdgeResponse> edges) {
		this.edges = edges;
	}
	
	
}
