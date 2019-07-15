package com.program.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.program.dto.CinemaRoomDTO;
import com.program.entity.CinemaRoomEntity;
import com.program.error.ResponseExceptionModel;
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
    if (cinemaRoomRepository.findById(model.getRoomId()) != null) {
      return new ResponseExceptionModel(Boolean.FALSE, "Room id  alreadly exists", HttpStatus.CONFLICT);
    }
    if (cinemaRoomRepository.save(model.convert()) != null) {
      return new ResponseExceptionModel(Boolean.FALSE, "Can't add new room, something went wrong", HttpStatus.CONFLICT);
    } else {
      return new ResponseExceptionModel(Boolean.TRUE, "Success, new Room created", HttpStatus.CONFLICT);
    }
  }

  @Override
  public ResponseExceptionModel update(final CinemaRoomDTO model) {
    if (cinemaRoomRepository.save(model.convert()) != null) {
      return new ResponseExceptionModel(Boolean.TRUE, "Room update Success", HttpStatus.OK);
    }
    return new ResponseExceptionModel(Boolean.FALSE, "can't update Room, something went wrong",
        HttpStatus.UNPROCESSABLE_ENTITY);
  }

  @Override
  public ResponseExceptionModel delete(final Long id) {
    if (id == null) {
      return new ResponseExceptionModel(Boolean.FALSE, "Id cannot be null", HttpStatus.BAD_REQUEST);
    }
    cinemaRoomRepository.deleteById(id);
    return new ResponseExceptionModel(Boolean.TRUE, "Delete Success", HttpStatus.OK);
  }

}
