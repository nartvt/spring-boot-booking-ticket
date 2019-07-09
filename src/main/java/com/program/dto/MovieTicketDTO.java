package com.program.dto;

import java.sql.Timestamp;

import com.program.entity.MovieTicketEntity;
import com.program.entity.SeatEntity;
import com.program.entity.ShowtimeEntity;
import com.program.entity.UserEntity;

public class MovieTicketDTO {
  private Long ticketId;

  private long totalAmount;

  private Timestamp bookingDate;

  private SeatEntity seat;

  private UserEntity user;

  private ShowtimeEntity show;

  public MovieTicketDTO() {

  }

  public MovieTicketDTO(final MovieTicketEntity entity) {
    this.ticketId = entity.getTicketId();
    this.totalAmount = entity.getTotalAmount();
    this.bookingDate = entity.getBookingDate();
    this.seat = entity.getSeat();
    this.user = entity.getUser();
    this.show = entity.getShow();
  }

  public MovieTicketEntity convert() {
    final MovieTicketEntity entity = new MovieTicketEntity();
    entity.setTicketId(this.ticketId);
    entity.setTotalAmount(this.totalAmount);
    entity.setBookingDate(this.bookingDate);
    entity.setSeat(this.seat);
    entity.setUser(this.user);
    entity.setShow(this.show);
    return entity;
  }

  public Long getTicketId() {
    return ticketId;
  }

  public void setTicketId(Long ticketId) {
    this.ticketId = ticketId;
  }

  public long getTotalAmount() {
    return totalAmount;
  }

  public void setTotalMount(long totalAmount) {
    this.totalAmount = totalAmount;
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
