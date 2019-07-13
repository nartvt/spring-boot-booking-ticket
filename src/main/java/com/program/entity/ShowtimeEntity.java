package com.program.entity;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "Showtimes")
public class ShowtimeEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "showTimeId")
  private Long showTimeId;

  @Column(name = "showDay")
  private Timestamp showDay;

  @Column(name = "showDate")
  private Timestamp showDate;

  @Column(name = "ticketFare")
  private long ticketFare;

  @ManyToOne(fetch = FetchType.LAZY, optional = true)
  @JoinColumn(name = "movieId", nullable = true)
  private MovieEntity movie;

  @ManyToOne(fetch = FetchType.LAZY, optional = true)
  @JoinColumn(name = "roomId", nullable = true)
  private CinemaRoomEntity room;

  @JsonIgnore
  @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
  private Set<MovieTicketEntity> movieTickets;

  public Long getShowTimeId() {
    return showTimeId;
  }

  public void setShowTimeId(Long showTimeId) {
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

  public long getTicketFare() {
    return ticketFare;
  }

  public void setTicketFare(long ticketFare) {
    this.ticketFare = ticketFare;
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
