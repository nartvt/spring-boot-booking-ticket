package com.program.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.program.dto.CinemaRoomDTO;
import com.program.entity.CinemaRoomEntity;
import com.program.repository.CinemaRoomRepository;
import com.program.service.CinemaRoomService;

@Service
public class CinemaRoomServiceImpl implements CinemaRoomService {

  @Autowired
  private CinemaRoomRepository cinemaRoomRepository;

  @Override
  public List<CinemaRoomDTO> findAll() {
    final List<CinemaRoomEntity> entities = cinemaRoomRepository.findAll();
    if (entities != null) {
      final List<CinemaRoomDTO> cinemaRoomDTOs = Lists.newArrayList();
      entities.forEach(entity -> {
        final CinemaRoomDTO dto = new CinemaRoomDTO(entity);
        cinemaRoomDTOs.add(dto);
      });
      return cinemaRoomDTOs;
    }
    return Lists.newArrayList();
  }

  @Override
  public CinemaRoomDTO findById(final Long id) {
    final CinemaRoomEntity entity = cinemaRoomRepository.findById(id).get();
    return new CinemaRoomDTO(entity);
  }

  @Override
  public ResponseExceptionModel insert(final CinemaRoomDTO model) {
    if (cinemaRoomRepository.findByRoomName(model.getRoomName()) != null) {
      return false;
    }
    cinemaRoomRepository.save(model.convert());
    return true;
  }

  @Override
  public ResponseExceptionModel update(final CinemaRoomDTO model) {
    final CinemaRoomEntity entity = cinemaRoomRepository.save(model.convert());
    if (entity == null) {
      return false;
    }
    return true;
  }

  @Override
  public ResponseExceptionModel delete(final Long id) {
    if (id == null) {
      return false;
    }
    cinemaRoomRepository.deleteById(id);
    return true;
  }

}
