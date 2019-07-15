package com.program.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.program.dto.CineplexDTO;
import com.program.entity.CineplexEntity;
import com.program.error.ResponseExceptionModel;
import com.program.repository.CineplexRepository;
import com.program.service.CineplexService;

@Service
public class CineplexServiceImpl implements CineplexService {

  @Autowired
  private CineplexRepository cineplexRepository;

  @Override
  public List<CineplexDTO> findAll() {
    final List<CineplexEntity> entities = cineplexRepository.findAll();

    if (entities != null) {

      final List<CineplexDTO> cineplexDTOs = Lists.newArrayList();
      entities.forEach(entity -> {
        final CineplexDTO dto = new CineplexDTO(entity);
        cineplexDTOs.add(dto);
      });
      return cineplexDTOs;
    }

    return Lists.newArrayList();
  }

  @Override
  public CineplexDTO findById(Long id) {
    final CineplexEntity entity = cineplexRepository.findById(id).get();
    return new CineplexDTO(entity);
  }

  @Override
  public ResponseExceptionModel insert(CineplexDTO model) {
    if (cineplexRepository.findById(model.getCineplexId()) != null) {
      return new ResponseExceptionModel(Boolean.FALSE, "Cineplex id  alreadly exists", HttpStatus.CONFLICT);
    }
    if (cineplexRepository.save(model.convert()) != null) {
      return new ResponseExceptionModel(Boolean.FALSE, "Can't add new cineplex, something went wrong",
          HttpStatus.CONFLICT);
    } else {
      return new ResponseExceptionModel(Boolean.TRUE, "Success, new cineplex created", HttpStatus.CONFLICT);
    }
  }

  @Override
  public ResponseExceptionModel update(CineplexDTO model) {
    if (cineplexRepository.save(model.convert()) != null) {
      return new ResponseExceptionModel(Boolean.TRUE, "Cineplex update Success", HttpStatus.OK);
    }
    return new ResponseExceptionModel(Boolean.FALSE, "can't update cineplex, something went wrong",
        HttpStatus.UNPROCESSABLE_ENTITY);
  }

  @Override
  public ResponseExceptionModel delete(Long id) {
    if (id == null) {
      return new ResponseExceptionModel(Boolean.FALSE, "Id cannot be null", HttpStatus.BAD_REQUEST);
    }
    cineplexRepository.deleteById(id);
    return new ResponseExceptionModel(Boolean.TRUE, "Delete Success", HttpStatus.OK);
  }

}
