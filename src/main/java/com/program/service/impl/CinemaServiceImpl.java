package com.program.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.program.dto.CinemaDTO;
import com.program.entity.CinemaEntity;
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
  public boolean insert(final CinemaDTO model) {
    if (cinemaRepository.findByCinemaName(model.getCinemaName()) != null) {
      return false;
    }
    cinemaRepository.save(model.convert());
    return true;
  }

  @Override
  public boolean update(final CinemaDTO model) {
    final CinemaEntity entity = cinemaRepository.save(model.convert());
    if (entity == null) {
      return false;
    }
    return true;
  }

  @Override
  public boolean delete(final Long id) {
    if (id == null) {
      return false;
    }
    cinemaRepository.deleteById(id);
    return true;
  }

}
