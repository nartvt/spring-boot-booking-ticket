package com.program.repository;

import org.springframework.stereotype.Repository;

import com.program.entity.CineplexEntity;

@Repository
public interface CineplexRepository extends BaseRepository<CineplexEntity, Long> {

  CineplexEntity findByCineplexName(String name);
}
