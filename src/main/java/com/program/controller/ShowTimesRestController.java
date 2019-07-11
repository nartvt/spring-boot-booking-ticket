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
import com.program.dto.ShowTimesDTO;
import com.program.service.ShowTimesService;

@RestController
@RequestMapping("/rest/api/show-times")
public class ShowTimesRestController {

  @Autowired
  private ShowTimesService showtimeService;

  @GetMapping(value = RestContant.REST_ALL)
  public @ResponseBody List<ShowTimesDTO> showTimes() {
    List<ShowTimesDTO> showTimes = showtimeService.findAll();
    return showTimes;
  }

  @GetMapping(value = RestContant.REST_BY_ID)
  public @ResponseBody ShowTimesDTO showTime(@PathVariable("id") Long id) {
    ShowTimesDTO showTime = showtimeService.findById(id);
    return showTime;
  }

  @PostMapping(value = RestContant.REST_ADD)
  public ResponseEntity<Object> createShowTime(@RequestBody ShowTimesDTO model) {
    boolean status = showtimeService.insert(model);
    if (status == false) {
      return ResponseEntity.notFound().build();
    }
    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(RestContant.REST_BY_ID)
        .buildAndExpand(model.getShowTimeId()).toUri();
    return ResponseEntity.created(location).build();
  }

  @PutMapping(value = RestContant.REST_UPDATE)
  public ResponseEntity<Object> updateShowTime(@RequestBody ShowTimesDTO model) {
    ShowTimesDTO showTimeOptional = showtimeService.findById(model.getShowTimeId());
    if (showTimeOptional == null) {
      return ResponseEntity.notFound().build();
    }
    showtimeService.update(model);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping(value = RestContant.REST_DELETE_BY_ID)
  public Map<String, Boolean> deleteShowTime(@PathVariable(value = "id") Long id) {
    Map<String, Boolean> response = new HashMap<String, Boolean>();
    boolean isDeleteStatus = showtimeService.delete(id);

    if (isDeleteStatus == false) {
      response.put("undeleted", isDeleteStatus);
      return response;
    }
    response.put("deleted", isDeleteStatus);
    return response;
  }
}
