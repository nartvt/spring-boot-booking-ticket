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
import com.program.dto.CinemaRoomDTO;
import com.program.error.ResponseExceptionModel;
import com.program.service.CinemaRoomService;

@RestController
@RequestMapping("/rest/api/cinema-room")
public class CinemaRoomRestController {

  @Autowired
  private CinemaRoomService cinemaRoomService;

  @GetMapping(value = RestContant.REST_ALL)
  public List<CinemaRoomDTO> cinemaRooms() {
    List<CinemaRoomDTO> CinemaRoomDTOs = cinemaRoomService.findAll();
    return CinemaRoomDTOs;
  }

  @GetMapping(value = RestContant.REST_BY_ID)
  public CinemaRoomDTO cinemaRoom(@PathVariable("id") Long cinemaId) {
    CinemaRoomDTO CinemaRoomDTO = cinemaRoomService.findById(cinemaId);
    return CinemaRoomDTO;
  }

  @PostMapping(value = RestContant.REST_ADD)
  public ResponseEntity<Object> createCinemaRoom(@RequestBody CinemaRoomDTO model) {
    ResponseExceptionModel responseException = cinemaRoomService.insert(model);
    return new ResponseEntity<>(responseException, responseException.getHttpMessage());
  }

  @PutMapping(value = RestContant.REST_UPDATE)
  public ResponseEntity<Object> updateCinemaRoom(@RequestBody CinemaRoomDTO model) {
    ResponseExceptionModel responseException = cinemaRoomService.update(model);
    return new ResponseEntity<>(responseException, responseException.getHttpMessage());
  }

  @DeleteMapping(value = RestContant.REST_DELETE_BY_ID)
  public ResponseEntity<Object> deleteCinemaRoom(@PathVariable(value = "id") Long cinemaId) {
    ResponseExceptionModel responseException = cinemaRoomService.delete(cinemaId);
    return new ResponseEntity<>(responseException, responseException.getHttpMessage());
  }
}
