package com.program.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.program.dto.CineplexDTO;
import com.program.entity.CineplexEntity;
import com.program.repository.CineplexRepository;
import com.program.service.CineplexService;

@Service
public class CineplexServiceImpl implements CineplexService{

  
  @Autowired
  private CineplexRepository  cineplexRepository; 
  
  @Override
  public List<CineplexDTO> findAll() {
    final List<CineplexEntity> entities = cineplexRepository.findAll();
    
    if(entities!=null) {
      
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
  public boolean insert(CineplexDTO model) {
    if (cineplexRepository.findByCineplexName(model.getCineplexName()) != null) {
      return false;
    }
    cineplexRepository.save(model.convert());
    return true;
  }

  @Override
  public boolean update(CineplexDTO model) {
    final CineplexEntity entity = cineplexRepository.save(model.convert());
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
    cineplexRepository.deleteById(id);
    return true;
  }

}
