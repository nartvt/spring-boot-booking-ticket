package com.program.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.program.dto.ShowTimesDTO;
import com.program.entity.ShowtimeEntity;
import com.program.repository.ShowTimesRepository;
import com.program.service.ShowTimesService;

@Service
public class ShowTimesServiceImpl implements ShowTimesService {

  @Autowired
  private ShowTimesRepository showTimesRepository;

  @Override
  public List<ShowTimesDTO> findAll() {
    final List<ShowtimeEntity> entitys = showTimesRepository.findAll();
    if (entitys != null) {
      final List<ShowTimesDTO> showTimesDTOs = Lists.newArrayList();
      entitys.forEach(entity -> {
        final ShowTimesDTO dto = new ShowTimesDTO(entity);
        showTimesDTOs.add(dto);
      });
      return showTimesDTOs;
    }

    return Lists.newArrayList();
  }

  @Override
  public ShowTimesDTO findById(Long id) {
    final ShowtimeEntity entity = showTimesRepository.findById(id).get();
    return new ShowTimesDTO(entity);
  }

  @Override
  public boolean insert(ShowTimesDTO model) {
    showTimesRepository.save(model.convert());
    return true;
  }

  @Override
  public boolean update(ShowTimesDTO model) {
    final ShowtimeEntity entity = showTimesRepository.save(model.convert());
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
    showTimesRepository.deleteById(id);
    return true;
  }

}
