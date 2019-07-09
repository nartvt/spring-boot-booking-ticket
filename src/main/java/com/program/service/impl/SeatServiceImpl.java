package com.program.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.program.dto.SeatDTO;
import com.program.entity.SeatEntity;
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
  public boolean insert(final SeatDTO model) {
    // same name but difference room
    if (model == null) {
      return false;
    }
    seatRepository.save(model.convert());
    return true;
  }

  @Override
  public boolean update(SeatDTO model) {
    final SeatEntity entity = seatRepository.save(model.convert());
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
    seatRepository.deleteById(id);
    return true;
  }

}
