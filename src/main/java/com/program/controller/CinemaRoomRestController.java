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
import com.program.dto.CinemaRoomDTO;
import com.program.service.CinemaRoomService;

@RestController
@RequestMapping("/rest/api/cinema-room")
public class CinemaRoomRestController {

  @Autowired
  private CinemaRoomService cinemaRoomService;

  @GetMapping(value = RestContant.REST_ALL)
  public @ResponseBody List<CinemaRoomDTO> cinemaRooms() {
    List<CinemaRoomDTO> CinemaRoomDTOs = cinemaRoomService.findAll();
    return CinemaRoomDTOs;
  }

  @GetMapping(value = RestContant.REST_BY_ID)
  public @ResponseBody CinemaRoomDTO cinemaRoom(@PathVariable("id") Long cinemaId) {
    CinemaRoomDTO CinemaRoomDTO = cinemaRoomService.findById(cinemaId);
    return CinemaRoomDTO;
  }

  @PostMapping(value = RestContant.REST_ADD)
  public ResponseEntity<Object> createCinemaRoom(@RequestBody CinemaRoomDTO model) {
    boolean status = cinemaRoomService.insert(model);
    if (status == false) {
      return ResponseEntity.notFound().build();
    }
    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(RestContant.REST_BY_ID)
        .buildAndExpand(model.getRoomId()).toUri();
    return ResponseEntity.created(location).build();
  }

  @PutMapping(value = RestContant.REST_UPDATE)
  public ResponseEntity<Object> updateCinemaRoom(@RequestBody CinemaRoomDTO model) {
    CinemaRoomDTO cinemaOptional = cinemaRoomService.findById(model.getRoomId());
    if (cinemaOptional == null) {
      return ResponseEntity.notFound().build();
    }
    cinemaRoomService.update(model);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping(value = RestContant.REST_DELETE_BY_ID)
  public Map<String, Boolean> deleteCinemaRoom(@PathVariable(value = "id") Long cinemaId) {
    Map<String, Boolean> response = new HashMap<String, Boolean>();
    boolean isDeleteStatus = cinemaRoomService.delete(cinemaId);

    if (isDeleteStatus == false) {
      response.put("undeleted", isDeleteStatus);
      return response;
    }
    response.put("deleted", isDeleteStatus);
    return response;
  }
}
