package com.program.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.program.dto.MovieDTO;
import com.program.entity.MovieEntity;
import com.program.repository.MovieRepositoty;
import com.program.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

  @Autowired
  private MovieRepositoty movieRepositoty;

  @Override
  public List<MovieDTO> findAll() {
    final List<MovieEntity> entitys = movieRepositoty.findAll();
    if (entitys != null) {
      final List<MovieDTO> movieDTOs = Lists.newArrayList();
      entitys.forEach(entity -> {
        final MovieDTO dto = new MovieDTO(entity);
        movieDTOs.add(dto);
      });
      return movieDTOs;
    }

    return Lists.newArrayList();
  }

  @Override
  public MovieDTO findById(Long id) {
    final MovieEntity entity = movieRepositoty.findById(id).get();
    return new MovieDTO(entity);
  }

  @Override
  public boolean insert(MovieDTO model) {
    if (movieRepositoty.findByMovieName(model.getMovieName()) != null) {
      return false;
    }
    movieRepositoty.save(model.convert());
    return true;
  }

  @Override
  public boolean update(MovieDTO model) {
    final MovieEntity entity = movieRepositoty.save(model.convert());
    if (entity == null) {
      return false;
    }
    return true;
  }

  @Override
  public boolean delete(Long id) {
    if (id == null) {
      return false;
    }
    movieRepositoty.deleteById(id);
    return true;
  }

}
