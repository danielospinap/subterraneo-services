package com.metro.subterraneo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metro.subterraneo.model.Query;
import com.metro.subterraneo.model.Station;

@Repository("queryRepository")
public interface QueryRepository extends JpaRepository<Query, Long> {
	
	public List<Query> findByOriginStationAndDestinationStation(Station origin, Station destination);

}
