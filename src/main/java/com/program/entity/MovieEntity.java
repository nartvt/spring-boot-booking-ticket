package com.program.entity;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Movie")
public class MovieEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "movieId")
  private Long movieId;

  @Column(name = "movieName")
  private String movieName;

  @Column(name = "movieImage")
  private String movieImage;

  @Column(name = "trailer")
  private String trailer;

  @Column(name = "description")
  private String description;

  @Column(name = "movieDuration")
  private long movieDuration;

  @Column(name = "movieReleaseDate")
  private Timestamp movieReleaseDate;

  @Column(name = "review")
  private String review;

  @JsonIgnore
  @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY)
  private Set<ShowtimeEntity> showtimes;

  @JsonIgnore
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "CinemaMovie", 
  joinColumns = @JoinColumn(name = "movieId", referencedColumnName = "movieId"), 
  inverseJoinColumns = @JoinColumn(name = "cinemaId", referencedColumnName = "cinemaId"))
  private Set<CinemaEntity> cinemaEntitys;
  
  
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

  public Set<ShowtimeEntity> getShowtimes() {
    return showtimes;
  }

  public void setShowtimes(Set<ShowtimeEntity> showtimes) {
    this.showtimes = showtimes;
  }

  public Set<CinemaEntity> getCinemaEntitys() {
    return cinemaEntitys;
  }

  public void setCinemaEntitys(Set<CinemaEntity> cinemaEntitys) {
    this.cinemaEntitys = cinemaEntitys;
  }

}
