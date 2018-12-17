package com.metro.subterraneo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metro.subterraneo.model.Station;

@Repository("stationRepository")
public interface StationRepository extends JpaRepository<Station, Long> {

}
