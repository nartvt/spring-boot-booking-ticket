package com.program.entity;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "Movie")
public class MovieEntity {
  @Id
  private String movieId;
  private String movieName;
  private String movieImage;
  private String trailer;
  private String description;
  private long movieDuration;
  private Timestamp movieReleaseDate;
  private String review;

  @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
  private Set<ShowtimeEntity> showtimes;

  public String getMovieId() {
    return movieId;
  }

  public void setMovieId(String movieId) {
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

  public Set<ShowtimeEntity> getShowtimes() {
    return showtimes;
  }

  public void setShowtimes(Set<ShowtimeEntity> showtimes) {
    this.showtimes = showtimes;
  }

}
