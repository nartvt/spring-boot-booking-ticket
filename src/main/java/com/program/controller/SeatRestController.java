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
import com.program.dto.SeatDTO;
import com.program.error.ResponseExceptionModel;
import com.program.service.SeatService;

@RestController
@RequestMapping("/rest/api/seat")
public class SeatRestController {

  @Autowired
  private SeatService seatService;

  @GetMapping(value = RestContant.REST_ALL)
  public @ResponseBody List<SeatDTO> seatMany() {
    List<SeatDTO> seats = seatService.findAll();
    return seats;
  }

  @GetMapping(value = RestContant.REST_BY_ID)
  public @ResponseBody SeatDTO seatOne(@PathVariable("id") Long seatId) {
    SeatDTO seat = seatService.findById(seatId);
    return seat;
  }

  @PostMapping(value = RestContant.REST_ADD)
  public ResponseEntity<Object> createseat(@RequestBody SeatDTO model) {
    ResponseExceptionModel response  = seatService.insert(model);
    if (status == false) {
      return ResponseEntity.notFound().build();
    }
    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(RestContant.REST_BY_ID)
        .buildAndExpand(model.getSeatId()).toUri();
    return ResponseEntity.created(location).build();
  }

  @PutMapping(value = RestContant.REST_UPDATE)
  public ResponseEntity<Object> updateseat(@RequestBody SeatDTO model) {
    SeatDTO seatOptional = seatService.findById(model.getSeatId());
    if (seatOptional == null) {
      return ResponseEntity.notFound().build();
    }
    seatService.update(model);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping(value = RestContant.REST_DELETE_BY_ID)
  public Map<String, Boolean> deleteseat(@PathVariable(value = "id") Long id) {
    Map<String, Boolean> response = new HashMap<String, Boolean>();
    ResponseExceptionModel  responseException = seatService.delete(id);

    if (isDeleteStatus == false) {
      response.put("undeleted", isDeleteStatus);
      return response;
    }
    response.put("deleted", isDeleteStatus);
    return response;
  }
}
