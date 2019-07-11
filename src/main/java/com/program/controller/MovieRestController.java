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
import com.program.dto.MovieDTO;
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
    boolean status = movieService.insert(model);
    if (status == false) {
      return ResponseEntity.notFound().build();
    }
    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(RestContant.REST_BY_ID)
        .buildAndExpand(model.getMovieId()).toUri();
    return ResponseEntity.created(location).build();
  }

  @PutMapping(value = RestContant.REST_UPDATE)
  public ResponseEntity<Object> updateMovieOne(@RequestBody MovieDTO model) {
    MovieDTO movieDTO = movieService.findById(model.getMovieId());
    if (movieDTO == null) {
      return ResponseEntity.notFound().build();
    }
    movieService.update(model);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping(value = RestContant.REST_DELETE_BY_ID)
  public Map<String, Boolean> deleteMovieOne(@PathVariable(value = "id") Long movieId) {
    Map<String, Boolean> response = new HashMap<String, Boolean>();
    boolean isDeleteStatus = movieService.delete(movieId);

    if (isDeleteStatus == false) {
      response.put("undeleted", isDeleteStatus);
      return response;
    }
    response.put("deleted", isDeleteStatus);
    return response;
  }

}
