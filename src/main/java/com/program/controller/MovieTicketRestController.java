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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.program.conmmon.RestContant;
import com.program.dto.MovieTicketDTO;
import com.program.error.ResponseExceptionModel;
import com.program.service.MovieTicketService;

@RestController
@RequestMapping("/rest/api/movie-ticket")
public class MovieTicketRestController {

  @Autowired
  private MovieTicketService movieTicketService;

  @GetMapping(value = RestContant.REST_ALL)
  public @ResponseBody List<MovieTicketDTO> movieTickets() {
    List<MovieTicketDTO> movieTicketDTOs = movieTicketService.findAll();
    return movieTicketDTOs;
  }

  @GetMapping(value = RestContant.REST_BY_ID)
  public @ResponseBody MovieTicketDTO movieTicket(@PathVariable("id") Long id) {
    MovieTicketDTO movieTicketDTO = movieTicketService.findById(id);
    return movieTicketDTO;
  }

  @PostMapping(value = RestContant.REST_ADD)
  public ResponseEntity<Object> createMovieTicket(@RequestBody MovieTicketDTO model) {
    ResponseExceptionModel responseException  = movieTicketService.insert(model);
    return new ResponseEntity<>(responseException,responseException.getHttpCode());
  }

  @PutMapping(value = RestContant.REST_UPDATE)
  public ResponseEntity<Object> updateMovieTicket(@RequestBody MovieTicketDTO model) {
    ResponseExceptionModel  responseException=  movieTicketService.update(model);
    return new ResponseEntity<>(responseException,responseException.getHttpCode());
  }

  @DeleteMapping(value = RestContant.REST_DELETE_BY_ID)
  public ResponseEntity<Object>  deleteMovieTicket(@PathVariable(value = "id") Long id) {
    ResponseExceptionModel  responseException = movieTicketService.delete(id);
    return new ResponseEntity<>(responseException,responseException.getHttpCode());
  }
}
