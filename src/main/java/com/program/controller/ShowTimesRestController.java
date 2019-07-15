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
import com.program.dto.ShowTimesDTO;
import com.program.error.ResponseExceptionModel;
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
    ResponseExceptionModel responseException = showtimeService.insert(model);
    return new ResponseEntity<>(responseException, responseException.getHttpMessage());
  }

  @PutMapping(value = RestContant.REST_UPDATE)
  public ResponseEntity<Object> updateShowTime(@RequestBody ShowTimesDTO model) {
    ResponseExceptionModel responseException = showtimeService.update(model);
    return new ResponseEntity<>(responseException, responseException.getHttpMessage());
  }

  @DeleteMapping(value = RestContant.REST_DELETE_BY_ID)
  public ResponseEntity<Object> deleteShowTime(@PathVariable(value = "id") Long id) {
    ResponseExceptionModel responseException = showtimeService.delete(id);
    return new ResponseEntity<>(responseException, responseException.getHttpMessage());
  }
}
