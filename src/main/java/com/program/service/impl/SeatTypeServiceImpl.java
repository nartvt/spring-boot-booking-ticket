package com.program.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.program.dto.SeatTypeDTO;
import com.program.entity.SeatTypeEntity;
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
  public boolean insert(SeatTypeDTO model) {
    if (seatTypeRepository.findBySeatTypeName(model.getSeatTypeName()) != null) {
      return false;
    }
    seatTypeRepository.save(model.convert());
    return true;
  }

  @Override
  public boolean update(SeatTypeDTO model) {
    final SeatTypeEntity entity = seatTypeRepository.save(model.convert());
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
    seatTypeRepository.deleteById(id);
    return true;
  }

}
