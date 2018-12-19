package com.metro.subterraneo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metro.subterraneo.model.Query;

@Repository("queryRepository")
public interface QueryRepository extends JpaRepository<Query, Long> {

}
