package com.program.repository;

import org.springframework.stereotype.Repository;

import com.program.entity.MovieEntity;

@Repository
public interface MovieRepositoty extends BaseRepository<MovieEntity, Long> {
  MovieEntity findByMovieName(String name);
}
