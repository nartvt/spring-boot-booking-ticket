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
import com.program.dto.SeatTypeDTO;
import com.program.error.ResponseExceptionModel;
import com.program.service.SeatTypeService;

@RestController
@RequestMapping("/rest/api/seat-type")
public class SeatTypeRestController {

  @Autowired
  private SeatTypeService seatTypeService;

  @GetMapping(value = RestContant.REST_ALL)
  public @ResponseBody List<SeatTypeDTO> seatTypeMany() {
    List<SeatTypeDTO> seattypes = seatTypeService.findAll();
    return seattypes;
  }

  @GetMapping(value = RestContant.REST_BY_ID)
  public @ResponseBody SeatTypeDTO seatTypeOne(@PathVariable("id") Long id) {
    SeatTypeDTO seatType = seatTypeService.findById(id);
    return seatType;
  }

  @PostMapping(value = RestContant.REST_ADD)
  public ResponseEntity<Object> createSeatType(@RequestBody SeatTypeDTO model) {
    ResponseExceptionModel responseException = seatTypeService.insert(model);
    return new ResponseEntity<>(responseException,responseException.getHttpMessage());
  }

  @PutMapping(value = RestContant.REST_UPDATE)
  public ResponseEntity<Object> updateSeatType(@RequestBody SeatTypeDTO model) {
    ResponseExceptionModel responseException = seatTypeService.update(model);
    return new ResponseEntity<>(responseException,responseException.getHttpMessage());
  }

  @DeleteMapping(value = RestContant.REST_DELETE_BY_ID)
  public ResponseEntity<Object> deleteSeatType(@PathVariable(value = "id") Long id) {
    ResponseExceptionModel responseException = seatTypeService.delete(id);
    return new ResponseEntity<>(responseException,responseException.getHttpMessage());
  }
}
