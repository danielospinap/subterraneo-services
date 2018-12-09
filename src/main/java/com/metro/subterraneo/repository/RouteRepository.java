package com.metro.subterraneo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metro.subterraneo.model.Route;

@Repository("routeRepository")
public interface RouteRepository extends JpaRepository<Route, Long> {

}
