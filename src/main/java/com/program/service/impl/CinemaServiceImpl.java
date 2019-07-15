package com.program.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.program.dto.CinemaDTO;
import com.program.entity.CinemaEntity;
import com.program.error.ResponseExceptionModel;
import com.program.repository.CinemaRepository;
import com.program.service.CinemaService;

@Service
public class CinemaServiceImpl implements CinemaService {

  @Autowired
  private CinemaRepository cinemaRepository;

  @Override
  public List<CinemaDTO> findAll() {
    final List<CinemaEntity> entitys = cinemaRepository.findAll();
    if (entitys != null) {
      final List<CinemaDTO> cinemaDTOs = Lists.newArrayList();
      entitys.forEach(entity -> {
        final CinemaDTO dto = new CinemaDTO(entity);
        cinemaDTOs.add(dto);
      });
      return cinemaDTOs;
    }

    return Lists.newArrayList();
  }

  @Override
  public CinemaDTO findById(final Long id) {
    final CinemaEntity entity = cinemaRepository.findById(id).get();
    return new CinemaDTO(entity);
  }

  @Override
  public ResponseExceptionModel insert(final CinemaDTO model) {
    if (cinemaRepository.findById(model.getCinemaId()) != null) {
      return new ResponseExceptionModel(Boolean.FALSE, "Cinema id  alreadly exists", HttpStatus.CONFLICT);
    }
    if (cinemaRepository.save(model.convert()) != null) {
      return new ResponseExceptionModel(Boolean.FALSE, "Can't add new Cinema, something went wrong",
          HttpStatus.CONFLICT);
    } else {
      return new ResponseExceptionModel(Boolean.TRUE, "Success, new Cinema created", HttpStatus.CONFLICT);
    }
  }

  @Override
  public ResponseExceptionModel update(final CinemaDTO model) {
    if (cinemaRepository.save(model.convert()) != null) {
      return new ResponseExceptionModel(Boolean.TRUE, "Cinema update Success", HttpStatus.OK);
    }
    return new ResponseExceptionModel(Boolean.FALSE, "can't update Cinema, something went wrong",
        HttpStatus.UNPROCESSABLE_ENTITY);
  }

  @Override
  public ResponseExceptionModel delete(final Long id) {
    if (id == null) {
      return new ResponseExceptionModel(Boolean.FALSE, "Id cannot be null", HttpStatus.BAD_REQUEST);
    }
    cinemaRepository.deleteById(id);
    return new ResponseExceptionModel(Boolean.TRUE, "Delete Success", HttpStatus.OK);
  }

}
