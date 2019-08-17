package com.program.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.program.dto.TicketDTO;
import com.program.entity.TicketEntity;
import com.program.error.ResponseExceptionModel;
import com.program.repository.MovieTicketRepository;
import com.program.service.MovieTicketService;

@Service
public class MovieTicketServiceImpl implements MovieTicketService {

  @Autowired
  private MovieTicketRepository movieTicketRepository;

  @Override
  public List<TicketDTO> findAll() {
    final List<TicketEntity> entitys = movieTicketRepository.findAll();
    if (entitys != null) {
      final List<TicketDTO> ticketDTOs = Lists.newArrayList();
      entitys.forEach(entity -> {
        final TicketDTO dto = new TicketDTO(entity);
        ticketDTOs.add(dto);
      });
      return ticketDTOs;
    }

    return Lists.newArrayList();
  }

  @Override
  public TicketDTO findById(Long id) {
    final TicketEntity entity = movieTicketRepository.findById(id).get();
    return new TicketDTO(entity);
  }

  @Override
  public ResponseExceptionModel insert(TicketDTO model) {
    if (movieTicketRepository.findById(model.getTicketId()) != null) {
      return new ResponseExceptionModel(Boolean.FALSE, "Ticket Code alreadly exists", HttpStatus.CONFLICT);
    }
    if (movieTicketRepository.save(model.convert()) != null) {
      return new ResponseExceptionModel(Boolean.FALSE, "Can't add new ticket, something went wrong",
          HttpStatus.CONFLICT);
    } else {
      return new ResponseExceptionModel(Boolean.TRUE, "Success, new movie ticket created", HttpStatus.CONFLICT);
    }
  }

  @Override
  public ResponseExceptionModel update(TicketDTO model) {
    if (movieTicketRepository.save(model.convert()) != null) {
      return new ResponseExceptionModel(Boolean.TRUE, "Movie update Success", HttpStatus.OK);
    }
    return new ResponseExceptionModel(Boolean.FALSE, "can't update movie, something went wrong",
        HttpStatus.UNPROCESSABLE_ENTITY);
  }

  @Override
  public ResponseExceptionModel delete(Long id) {
    if (id == null) {
      return new ResponseExceptionModel(Boolean.FALSE, "Id cannot be null", HttpStatus.BAD_REQUEST);
    }
    movieTicketRepository.deleteById(id);
    return new ResponseExceptionModel(Boolean.TRUE, "Delete Success", HttpStatus.OK);
  }

}
