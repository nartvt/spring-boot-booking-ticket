package com.program.dto;

import java.sql.Timestamp;

import com.program.entity.MovieEntity;

public class MovieDTO {
  private Long movieId;

  private String movieName;

  private String movieImage;

  private String trailer;

  private String description;

  private long movieDuration;

  private Timestamp movieReleaseDate;

  private String review;

  public MovieDTO() {

  }

  public MovieDTO(final MovieEntity entity) {
    this.movieId = entity.getMovieId();
    this.movieName = entity.getMovieName();
    this.movieImage = entity.getMovieImage();
    this.trailer = entity.getTrailer();
    this.description = entity.getDescription();
    this.movieDuration = entity.getMovieDuration();
    this.movieReleaseDate = entity.getMovieReleaseDate();
    this.review = entity.getReview();
  }

  public MovieEntity convert() {
    final MovieEntity entity = new MovieEntity();
    entity.setMovieName(this.movieName);
    entity.setMovieImage(this.movieImage);
    entity.setTrailer(this.trailer);
    entity.setDescription(this.description);
    entity.setMovieDuration(this.movieDuration);
    entity.setMovieReleaseDate(this.movieReleaseDate);
    entity.setReview(this.review);
    return entity;
  }
  
  public Long getMovieId() {
    return movieId;
  }

  public void setMovieId(Long movieId) {
    this.movieId = movieId;
  }

  public String getMovieName() {
    return movieName;
  }

  public void setMovieName(String movieName) {
    this.movieName = movieName;
  }

  public String getMovieImage() {
    return movieImage;
  }

  public void setMovieImage(String movieImage) {
    this.movieImage = movieImage;
  }

  public String getTrailer() {
    return trailer;
  }

  public void setTrailer(String trailer) {
    this.trailer = trailer;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public long getMovieDuration() {
    return movieDuration;
  }

  public void setMovieDuration(long movieDuration) {
    this.movieDuration = movieDuration;
  }

  public Timestamp getMovieReleaseDate() {
    return movieReleaseDate;
  }

  public void setMovieReleaseDate(Timestamp movieReleaseDate) {
    this.movieReleaseDate = movieReleaseDate;
  }

  public String getReview() {
    return review;
  }

  public void setReview(String review) {
    this.review = review;
  }
}
