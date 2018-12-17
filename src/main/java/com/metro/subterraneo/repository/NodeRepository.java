package com.metro.subterraneo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metro.subterraneo.model.Node;

@Repository("nodeRepository")
public interface NodeRepository extends JpaRepository<Node, Long> {

}
