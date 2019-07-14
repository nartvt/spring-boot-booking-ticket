package com.program.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.program.dto.MovieTicketDTO;
import com.program.entity.MovieTicketEntity;
import com.program.repository.MovieTicketRepository;
import com.program.service.MovieTicketService;


@Service
public class MovieTicketServiceImpl implements MovieTicketService {

  @Autowired 
  private MovieTicketRepository movieTicketRepository;
  
  @Override
  public List<MovieTicketDTO> findAll() {
    final List<MovieTicketEntity> entitys = movieTicketRepository.findAll();
    if (entitys != null) {
      final List<MovieTicketDTO> movieTicketDTOs = Lists.newArrayList();
      entitys.forEach(entity -> {
        final MovieTicketDTO dto = new MovieTicketDTO(entity);
        movieTicketDTOs.add(dto);
      });
      return movieTicketDTOs;
    }

    return Lists.newArrayList();
  }

  @Override
  public MovieTicketDTO findById(Long id) {
    final MovieTicketEntity entity = movieTicketRepository.findById(id).get();
    return new MovieTicketDTO(entity);
  }

  @Override
  public ResponseExceptionModel insert(MovieTicketDTO model) {
    movieTicketRepository.save(model.convert());
    return true;
  }

  @Override
  public ResponseExceptionModel update(MovieTicketDTO model) {
    final MovieTicketEntity entity = movieTicketRepository.save(model.convert());
    if (entity == null) {
      return false;
    }
    return true;
  }

  @Override
  public ResponseExceptionModel delete(Long id) {
    if (id == null) {
      return false;
    }
    movieTicketRepository.deleteById(id);
    return true;
  }

}
