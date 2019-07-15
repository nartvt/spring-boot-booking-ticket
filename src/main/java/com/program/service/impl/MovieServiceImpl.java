package com.program.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.program.dto.MovieDTO;
import com.program.entity.MovieEntity;
import com.program.error.ResponseExceptionModel;
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
  public ResponseExceptionModel insert(MovieDTO model) {
    if (movieRepositoty.findById(model.getMovieId()) != null) {
      return new ResponseExceptionModel(Boolean.FALSE, "Movie id  alreadly exists", HttpStatus.CONFLICT);
    }
    if (movieRepositoty.save(model.convert()) != null) {
      return new ResponseExceptionModel(Boolean.FALSE, "Can't add new movie, something went wrong",
          HttpStatus.CONFLICT);
    } else {
      return new ResponseExceptionModel(Boolean.TRUE, "Success, new movie created", HttpStatus.CONFLICT);
    }
  }

  @Override
  public ResponseExceptionModel update(MovieDTO model) {
    if (movieRepositoty.save(model.convert()) != null) {
      return new ResponseExceptionModel(Boolean.TRUE, "Movie update Success", HttpStatus.OK);
    }
    return new ResponseExceptionModel(Boolean.FALSE, "can't update movie, something went wrong",
        HttpStatus.UNPROCESSABLE_ENTITY);
  }

  @Override
  public ResponseExceptionModel delete(Long id) {
    if (id == null) {
      return new ResponseExceptionModel(Boolean.FALSE, "Id cannot be null", HttpStatus.BAD_REQUEST);
    }
    movieRepositoty.deleteById(id);
    return new ResponseExceptionModel(Boolean.TRUE, "Delete Success", HttpStatus.OK);
  }

}
