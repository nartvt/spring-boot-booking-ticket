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
import com.program.dto.CinemaDTO;
import com.program.error.ResponseExceptionModel;
import com.program.service.CinemaService;

@RestController
@RequestMapping("/rest/api/cinema")
public class CinemaRestController {

  @Autowired
  private CinemaService cinemaService;

  @GetMapping(value = RestContant.REST_ALL)
  public @ResponseBody List<CinemaDTO> cinemas() {
    List<CinemaDTO> cinemaDTOs = cinemaService.findAll();
    return cinemaDTOs;
  }

  @GetMapping(value = RestContant.REST_BY_ID)
  public @ResponseBody CinemaDTO cinema(@PathVariable("id") Long cinemaId) {
    CinemaDTO cinemaDTO = cinemaService.findById(cinemaId);
    return cinemaDTO;
  }

  @PostMapping(value = RestContant.REST_ADD)
  public ResponseEntity<Object> createCinema(@RequestBody CinemaDTO model) {
    ResponseExceptionModel responseException  = cinemaService.insert(model);
    if (status == false) {
      return ResponseEntity.notFound().build();
    }
    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(RestContant.REST_BY_ID)
        .buildAndExpand(model.getCinemaId()).toUri();
    return ResponseEntity.created(location).build();
  }

  @PutMapping(value =RestContant.REST_UPDATE)
  public ResponseEntity<Object> updateCinema(@RequestBody CinemaDTO model) {
    CinemaDTO cinemaOptional = cinemaService.findById(model.getCinemaId());
    if (cinemaOptional == null) {
      return ResponseEntity.notFound().build();
    }
    cinemaService.update(model);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping(value = RestContant.REST_DELETE_BY_ID)
  public Map<String, Boolean> deleteCinema(@PathVariable(value = "id") Long cinemaId) {
    Map<String, Boolean> response = new HashMap<String, Boolean>();
    ResponseExceptionModel  responseException = cinemaService.delete(cinemaId);

    if (isDeleteStatus == false) {
      response.put("undeleted", isDeleteStatus);
      return response;
    }
    response.put("deleted", isDeleteStatus);
    return response;
  }

}
