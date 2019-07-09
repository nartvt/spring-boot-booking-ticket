package com.program.repository;

import org.springframework.stereotype.Repository;

import com.program.entity.CinemaEntity;

@Repository
public interface CinemaRepository extends BaseRepository<CinemaEntity, Long> {

  CinemaEntity findByCinemaName(String name);
  
}
