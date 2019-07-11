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
import com.program.dto.SeatTypeDTO;
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
    boolean status = seatTypeService.insert(model);
    if (status == false) {
      return ResponseEntity.notFound().build();
    }
    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(RestContant.REST_BY_ID)
        .buildAndExpand(model.getSeatTypeId()).toUri();
    return ResponseEntity.created(location).build();
  }

  @PutMapping(value = RestContant.REST_UPDATE)
  public ResponseEntity<Object> updateSeatType(@RequestBody SeatTypeDTO model) {
    SeatTypeDTO seatTypeOptional = seatTypeService.findById(model.getSeatTypeId());
    if (seatTypeOptional == null) {
      return ResponseEntity.notFound().build();
    }
    seatTypeService.update(model);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping(value = RestContant.REST_DELETE_BY_ID)
  public Map<String, Boolean> deleteSeatType(@PathVariable(value = "id") Long id) {
    Map<String, Boolean> response = new HashMap<String, Boolean>();
    boolean isDeleteStatus = seatTypeService.delete(id);

    if (isDeleteStatus == false) {
      response.put("undeleted", isDeleteStatus);
      return response;
    }
    response.put("deleted", isDeleteStatus);
    return response;
  }
}
