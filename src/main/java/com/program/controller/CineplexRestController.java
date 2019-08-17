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
import com.program.dto.CineplexDTO;
import com.program.error.ResponseExceptionModel;
import com.program.service.CineplexService;

@RestController
@RequestMapping("/rest/api/cineplex")
public class CineplexRestController {

  @Autowired
  private CineplexService cineplexService;

  @GetMapping(value = RestContant.REST_ALL)
  public List<CineplexDTO> cineplexs() {
    List<CineplexDTO> cineplexDTOs = cineplexService.findAll();
    return cineplexDTOs;
  }

  @GetMapping(value = RestContant.REST_BY_ID)
  public CineplexDTO cineplex(@PathVariable("id") Long cineplexId) {
    CineplexDTO cineplexDTO = cineplexService.findById(cineplexId);
    return cineplexDTO;
  }

  @PostMapping(value = RestContant.REST_ADD)
  public ResponseEntity<Object> createCineplex(@RequestBody CineplexDTO model) {
    ResponseExceptionModel responseException = cineplexService.insert(model);
    return new ResponseEntity<>(responseException, responseException.getHttpMessage());
  }

  @PutMapping(value = RestContant.REST_UPDATE)
  public ResponseEntity<Object> updateCineplex(@RequestBody CineplexDTO model) {
    ResponseExceptionModel responseException = cineplexService.update(model);
    return new ResponseEntity<>(responseException, responseException.getHttpMessage());
  }

  @DeleteMapping(value = RestContant.REST_DELETE_BY_ID)
  public ResponseEntity<Object> deleteCinePlex(@PathVariable(value = "id") Long cineplexId) {
    ResponseExceptionModel responseException = cineplexService.delete(cineplexId);
    return new ResponseEntity<>(responseException, responseException.getHttpMessage());
  }
}
