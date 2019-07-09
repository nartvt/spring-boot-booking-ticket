package com.program.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name = "MovieTicket")
public class MovieTicketEntity {
  @Id
  private String ticketId;
  private long ticketPrice;
  private Timestamp bookingDate;

  @OneToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "seatId", nullable = false)
  private SeatEntity seat;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "userId", nullable = false)
  private UserEntity user;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "showtimeId", nullable = false)
  private ShowtimeEntity show;

  public String getTicketId() {
    return ticketId;
  }

  public void setTicketId(String ticketId) {
    this.ticketId = ticketId;
  }

  public long getTicketPrice() {
    return ticketPrice;
  }

  public void setTicketPrice(long ticketPrice) {
    this.ticketPrice = ticketPrice;
  }

  public Timestamp getBookingDate() {
    return bookingDate;
  }

  public void setBookingDate(Timestamp bookingDate) {
    this.bookingDate = bookingDate;
  }

  public SeatEntity getSeat() {
    return seat;
  }

  public void setSeat(SeatEntity seat) {
    this.seat = seat;
  }

  public UserEntity getUser() {
    return user;
  }

  public void setUser(UserEntity user) {
    this.user = user;
  }

  public ShowtimeEntity getShow() {
    return show;
  }

  public void setShow(ShowtimeEntity show) {
    this.show = show;
  }

}
