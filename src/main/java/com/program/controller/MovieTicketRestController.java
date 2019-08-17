package com.program.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.program.conmmon.RestContant;
import com.program.dto.TicketDTO;
import com.program.error.ResponseExceptionModel;
import com.program.service.MovieTicketService;

@RestController
@RequestMapping("/rest/api/movie-ticket")
public class MovieTicketRestController {

  @Autowired
  private MovieTicketService movieTicketService;

  @GetMapping(value = RestContant.REST_ALL)
  public List<TicketDTO> movieTickets() {
    List<TicketDTO> ticketDTOs = movieTicketService.findAll();
    return ticketDTOs;
  }

  @GetMapping(value = RestContant.REST_BY_ID)
  public TicketDTO movieTicket(@PathVariable("id") Long id) {
    TicketDTO ticketDTO = movieTicketService.findById(id);
    return ticketDTO;
  }

  @PostMapping(value = RestContant.REST_ADD)
  public ResponseEntity<Object> createMovieTicket(@RequestBody TicketDTO model) {
    ResponseExceptionModel responseException = movieTicketService.insert(model);
    return new ResponseEntity<>(responseException, responseException.getHttpMessage());
  }

  @PutMapping(value = RestContant.REST_UPDATE)
  public ResponseEntity<Object> updateMovieTicket(@RequestBody TicketDTO model) {
    ResponseExceptionModel responseException = movieTicketService.update(model);
    return new ResponseEntity<>(responseException, responseException.getHttpMessage());
  }

  @DeleteMapping(value = RestContant.REST_DELETE_BY_ID)
  public ResponseEntity<Object> deleteMovieTicket(@PathVariable(value = "id") Long id) {
    ResponseExceptionModel responseException = movieTicketService.delete(id);
    return new ResponseEntity<>(responseException, responseException.getHttpMessage());
  }
}
