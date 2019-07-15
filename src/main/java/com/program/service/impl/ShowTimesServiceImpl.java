package com.program.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.program.dto.ShowTimesDTO;
import com.program.entity.ShowtimeEntity;
import com.program.error.ResponseExceptionModel;
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
  public ResponseExceptionModel insert(ShowTimesDTO model) {
    if (showTimesRepository.findById(model.getShowTimeId()) != null) {
      return new ResponseExceptionModel(Boolean.FALSE, "Showtimes alreadly exists", HttpStatus.CONFLICT);
    }
    if (showTimesRepository.save(model.convert()) != null) {
      return new ResponseExceptionModel(Boolean.TRUE, "Add success", HttpStatus.CREATED);

    }
    return new ResponseExceptionModel(Boolean.FALSE, "Add unsuccess", HttpStatus.UNPROCESSABLE_ENTITY);
  }

  @Override
  public ResponseExceptionModel update(ShowTimesDTO model) {
    if (showTimesRepository.save(model.convert()) != null) {
      return new ResponseExceptionModel(Boolean.TRUE, "Update success", HttpStatus.OK);
    }
    return new ResponseExceptionModel(Boolean.FALSE, "Update unsuccess", HttpStatus.BAD_REQUEST);
  }

  @Override
  public ResponseExceptionModel delete(Long id) {
    if (id == null) {
      return new ResponseExceptionModel(Boolean.FALSE, "Delete un success", HttpStatus.NOT_ACCEPTABLE);
    }
    try {
      showTimesRepository.deleteById(id);

    } catch (Exception e) {
      e.printStackTrace();
    }
    return new ResponseExceptionModel(Boolean.TRUE, "Delete success", HttpStatus.OK);
  }

}
