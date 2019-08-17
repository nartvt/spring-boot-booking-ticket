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
import com.program.dto.SeatDTO;
import com.program.error.ResponseExceptionModel;
import com.program.service.SeatService;

@RestController
@RequestMapping("/rest/api/seat")
public class SeatRestController {

  @Autowired
  private SeatService seatService;

  @GetMapping(value = RestContant.REST_ALL)
  public List<SeatDTO> seatMany() {
    List<SeatDTO> seats = seatService.findAll();
    return seats;
  }

  @GetMapping(value = RestContant.REST_BY_ID)
  public SeatDTO seatOne(@PathVariable("id") Long seatId) {
    SeatDTO seat = seatService.findById(seatId);
    return seat;
  }

  @PostMapping(value = RestContant.REST_ADD)
  public ResponseEntity<Object> createseat(@RequestBody SeatDTO model) {
    ResponseExceptionModel responseException = seatService.insert(model);
    return new ResponseEntity<>(responseException, responseException.getHttpMessage());
  }

  @PutMapping(value = RestContant.REST_UPDATE)
  public ResponseEntity<Object> updateseat(@RequestBody SeatDTO model) {
    ResponseExceptionModel responseException = seatService.update(model);
    return new ResponseEntity<>(responseException, responseException.getHttpMessage());
  }

  @DeleteMapping(value = RestContant.REST_DELETE_BY_ID)
  public ResponseEntity<Object> deleteseat(@PathVariable(value = "id") Long id) {
    ResponseExceptionModel responseException = seatService.delete(id);
    return new ResponseEntity<>(responseException, responseException.getHttpMessage());

  }
}
