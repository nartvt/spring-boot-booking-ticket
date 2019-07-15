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
import com.program.dto.MovieDTO;
import com.program.error.ResponseExceptionModel;
import com.program.service.MovieService;

@RestController
@RequestMapping("/rest/api/movie")
public class MovieRestController {

  @Autowired
  private MovieService movieService;

  @GetMapping(value = RestContant.REST_ALL)
  public @ResponseBody List<MovieDTO> movies() {
    List<MovieDTO> moviesDTO = movieService.findAll();
    return moviesDTO;
  }

  @GetMapping(value = RestContant.REST_BY_ID)
  public @ResponseBody MovieDTO movieGetOne(@PathVariable("id") Long movieId) {
    MovieDTO movieDTO = movieService.findById(movieId);
    return movieDTO;
  }

  @PostMapping(value = RestContant.REST_ADD)
  public ResponseEntity<Object> createMovieOne(@RequestBody MovieDTO model) {
    ResponseExceptionModel responseException = movieService.insert(model);
    return new ResponseEntity<>(responseException, responseException.getHttpMessage());
  }

  @PutMapping(value = RestContant.REST_UPDATE)
  public ResponseEntity<Object> updateMovieOne(@RequestBody MovieDTO model) {
    ResponseExceptionModel responseException = movieService.update(model);
    return new ResponseEntity<>(responseException, responseException.getHttpMessage());
  }

  @DeleteMapping(value = RestContant.REST_DELETE_BY_ID)
  public ResponseEntity<Object> deleteMovieOne(@PathVariable(value = "id") Long movieId) {
    ResponseExceptionModel responseException = movieService.delete(movieId);
    return new ResponseEntity<>(responseException, responseException.getHttpMessage());
  }

}
