package com.metro.subterraneo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metro.subterraneo.model.Edge;

@Repository("edgeRepository")
public interface EdgeRepository extends JpaRepository<Edge, Long> {

}
