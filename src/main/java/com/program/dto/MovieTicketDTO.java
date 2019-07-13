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

  private Long seatEntityId;

  private Long userEntityId;

  private Long showtimeEntityId;

  public MovieTicketDTO() {

  }

  public MovieTicketDTO(final MovieTicketEntity entity) {
    this.ticketId = entity.getTicketId();
    this.totalAmount = entity.getTotalAmount();
    this.bookingDate = entity.getBookingDate();
    this.seatEntityId = entity.getSeat().getSeatId();
    this.userEntityId = entity.getUser().getUserId();
    this.showtimeEntityId = entity.getShow().getShowTimeId();
  }

  public MovieTicketEntity convert() {
    final MovieTicketEntity entity = new MovieTicketEntity();
    entity.setTicketId(this.ticketId);
    entity.setTotalAmount(this.totalAmount);
    entity.setBookingDate(this.bookingDate);
    
    SeatEntity seatEntity = new SeatEntity();
    entity.setSeat(seatEntity);
    
    UserEntity userEntity  = new UserEntity();
    userEntity.setUserId(this.userEntityId);
    entity.setUser(userEntity);
    
    ShowtimeEntity showtimeEntity = new ShowtimeEntity();
    showtimeEntity.setShowTimeId(this.showtimeEntityId);
    entity.setShow(showtimeEntity);
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

  public Long getSeat() {
    return seatEntityId;
  }

  public void setSeat(Long seat) {
    this.seatEntityId = seat;
  }

  public Long getUser() {
    return userEntityId;
  }

  public void setUser(Long user) {
    this.userEntityId = user;
  }

  public Long getShow() {
    return showtimeEntityId;
  }

  public void setShow(Long show) {
    this.showtimeEntityId = show;
  }
}
