package com.program.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.program.conmmon.RestContant;
import com.program.dto.MovieTicketDTO;
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
    boolean status = movieTicketService.insert(model);
    if (status == false) {
      return ResponseEntity.notFound().build();
    }
    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(RestContant.REST_BY_ID)
        .buildAndExpand(model.getTicketId()).toUri();
    return ResponseEntity.created(location).build();
  }

  @PutMapping(value = RestContant.REST_UPDATE)
  public ResponseEntity<Object> updateMovieTicket(@RequestBody MovieTicketDTO model) {
    MovieTicketDTO movieTicketDTO = movieTicketService.findById(model.getTicketId());
    if (movieTicketDTO == null) {
      return ResponseEntity.notFound().build();
    }
    movieTicketService.update(model);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping(value = RestContant.REST_DELETE_BY_ID)
  public Map<String, Boolean> deleteMovieTicket(@PathVariable(value = "id") Long id) {
    Map<String, Boolean> response = new HashMap<String, Boolean>();
    boolean isDeleteStatus = movieTicketService.delete(id);

    if (isDeleteStatus == false) {
      response.put("undeleted", isDeleteStatus);
      return response;
    }
    response.put("deleted", isDeleteStatus);
    return response;
  }
}
