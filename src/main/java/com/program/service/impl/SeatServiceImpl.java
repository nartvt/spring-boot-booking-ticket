package com.program.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.program.conmmon.MessageContant;
import com.program.dto.SeatDTO;
import com.program.entity.SeatEntity;
import com.program.error.ResponseExceptionModel;
import com.program.repository.SeatRepository;
import com.program.service.SeatService;

@Service
public class SeatServiceImpl implements SeatService {

  @Autowired
  private SeatRepository seatRepository;

  @Override
  public List<SeatDTO> findAll() {
    final List<SeatEntity> entitys = seatRepository.findAll();
    if (entitys != null) {
      final List<SeatDTO> seatDTOs = Lists.newArrayList();
      entitys.forEach(entity -> {
        final SeatDTO dto = new SeatDTO(entity);
        seatDTOs.add(dto);
      });
      return seatDTOs;
    }

    return Lists.newArrayList();
  }

  @Override
  public SeatDTO findById(Long id) {
    final SeatEntity entity = seatRepository.findById(id).get();
    return new SeatDTO(entity);
  }

  @Override
  public ResponseExceptionModel insert(final SeatDTO model) {
    if (model == null) {
      return new ResponseExceptionModel(Boolean.FALSE, "Seat Cannot be null", HttpStatus.BAD_REQUEST);
    }
    if (seatRepository.findById(model.getSeatId()) != null) {
      return new ResponseExceptionModel(Boolean.FALSE, "Seat Name alreadly exists", HttpStatus.CONFLICT);
    }
    if (seatRepository.save(model.convert()) != null) {
      return new ResponseExceptionModel(Boolean.TRUE, "Add Seat success", HttpStatus.CREATED);
    }
    return new ResponseExceptionModel(Boolean.FALSE, "add seat unsuccess".concat(MessageContant.SOMETHING_WENT_WRONG),
        HttpStatus.BAD_REQUEST);
  }

  @Override
  public ResponseExceptionModel update(SeatDTO model) {
    if (model == null) {
      return new ResponseExceptionModel(Boolean.FALSE, "Seat cannot be null", HttpStatus.BAD_REQUEST);
    }
    if (seatRepository.findById(model.getSeatId()) != null) {
      return new ResponseExceptionModel(Boolean.FALSE, "Seat alreadly exists", HttpStatus.CONFLICT);
    }
    if (seatRepository.save(model.convert()) != null) {
      return new ResponseExceptionModel(Boolean.TRUE, "Update seat success", HttpStatus.CREATED);
    }
    return new ResponseExceptionModel(Boolean.FALSE,
        "Update type of seat unsuccess".concat(MessageContant.SOMETHING_WENT_WRONG), HttpStatus.BAD_REQUEST);
  }

  @Override
  public ResponseExceptionModel delete(Long id) {
    if (id == null) {
      return new ResponseExceptionModel(Boolean.FALSE, "Delete unsuccess", HttpStatus.BAD_REQUEST);
    }
    seatRepository.deleteById(id);
    return new ResponseExceptionModel(Boolean.TRUE, "Delete success", HttpStatus.OK);
  }

}
