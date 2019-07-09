package com.program.entity;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "Showtimes")
public class ShowtimeEntity {
  @Id
  private String showTimeId;
  private Timestamp showDay;
  private Timestamp showDate;
  private long moviePrice;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "movieId", nullable = false)
  private MovieEntity movie;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "roomId", nullable = false)
  private CinemaRoomEntity room;

  @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
  private Set<MovieTicketEntity> movieTickets;

  public String getShowTimeId() {
    return showTimeId;
  }

  public void setShowTimeId(String showTimeId) {
    this.showTimeId = showTimeId;
  }

  public Timestamp getShowDay() {
    return showDay;
  }

  public void setShowDay(Timestamp showDay) {
    this.showDay = showDay;
  }

  public Timestamp getShowDate() {
    return showDate;
  }

  public void setShowDate(Timestamp showDate) {
    this.showDate = showDate;
  }

  public long getMoviePrice() {
    return moviePrice;
  }

  public void setMoviePrice(long moviePrice) {
    this.moviePrice = moviePrice;
  }

  public MovieEntity getMovie() {
    return movie;
  }

  public void setMovie(MovieEntity movie) {
    this.movie = movie;
  }

  public CinemaRoomEntity getRoom() {
    return room;
  }

  public void setRoom(CinemaRoomEntity room) {
    this.room = room;
  }

  public Set<MovieTicketEntity> getMovieTickets() {
    return movieTickets;
  }

  public void setMovieTickets(Set<MovieTicketEntity> movieTickets) {
    this.movieTickets = movieTickets;
  }
  
  
}
