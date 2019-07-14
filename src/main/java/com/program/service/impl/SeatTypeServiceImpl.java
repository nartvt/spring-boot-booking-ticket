package com.program.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.program.conmmon.MessageContant;
import com.program.dto.SeatTypeDTO;
import com.program.entity.SeatTypeEntity;
import com.program.error.ResponseExceptionModel;
import com.program.repository.SeatTypeRepository;
import com.program.service.SeatTypeService;

@Service
public class SeatTypeServiceImpl implements SeatTypeService {

  @Autowired
  private SeatTypeRepository seatTypeRepository;

  @Override
  public List<SeatTypeDTO> findAll() {
    final List<SeatTypeEntity> entitys = seatTypeRepository.findAll();
    if (entitys != null) {
      final List<SeatTypeDTO> seatTypeDTOs = Lists.newArrayList();
      entitys.forEach(entity -> {
        final SeatTypeDTO dto = new SeatTypeDTO(entity);
        seatTypeDTOs.add(dto);
      });
      return seatTypeDTOs;
    }

    return Lists.newArrayList();
  }

  @Override
  public SeatTypeDTO findById(Long id) {
    final SeatTypeEntity entity = seatTypeRepository.findById(id).get();
    return new SeatTypeDTO(entity);
  }

  @Override
  public ResponseExceptionModel insert(SeatTypeDTO model) {
    if (model == null) {
      return new ResponseExceptionModel(Boolean.FALSE, "Type of seat cannot be null", HttpStatus.BAD_REQUEST);
    }
    if (seatTypeRepository.findBySeatTypeName(model.getSeatTypeName()) != null
        || seatTypeRepository.findById(model.getSeatTypeId()) != null) {
      return new ResponseExceptionModel(Boolean.FALSE, "Name of type of seat alreadly exists", HttpStatus.CONFLICT);
    }
    if (seatTypeRepository.save(model.convert()) != null) {
      return new ResponseExceptionModel(Boolean.TRUE, "add type of Seat success", HttpStatus.CREATED);
    }
    return new ResponseExceptionModel(Boolean.FALSE,
        "add type seat unsuccess".concat(MessageContant.SOMETHING_WENT_WRONG), HttpStatus.BAD_REQUEST);
  }

  @Override
  public ResponseExceptionModel update(SeatTypeDTO model) {
    if (model == null) {
      return new ResponseExceptionModel(Boolean.FALSE, "Seat cannot be null", HttpStatus.BAD_REQUEST);
    }
    if (seatTypeRepository.findBySeatTypeName(model.getSeatTypeName()) != null) {
      return new ResponseExceptionModel(Boolean.FALSE, "Seat alreadly exists", HttpStatus.CONFLICT);
    }
    if (seatTypeRepository.save(model.convert()) != null) {
      return new ResponseExceptionModel(Boolean.TRUE, "Update type of seat success", HttpStatus.CREATED);
    }
    return new ResponseExceptionModel(Boolean.FALSE,
        "Update type of seat unsuccess".concat(MessageContant.SOMETHING_WENT_WRONG), HttpStatus.BAD_REQUEST);
  }

  @Override
  public ResponseExceptionModel delete(Long id) {
    if (id == null) {
      return new ResponseExceptionModel(Boolean.FALSE, "Delete unsuccess", HttpStatus.BAD_REQUEST);
    }
    seatTypeRepository.deleteById(id);
    return new ResponseExceptionModel(Boolean.TRUE, "Delete success", HttpStatus.OK);
  }

}
