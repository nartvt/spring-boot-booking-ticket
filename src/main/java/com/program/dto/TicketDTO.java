package com.program.dto;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import com.program.entity.TicketEntity;
import com.program.entity.SeatEntity;
import com.program.entity.ShowtimeEntity;
import com.program.entity.UserEntity;

public class TicketDTO {
  private Long ticketId;

  private long totalAmount;

  private Timestamp bookingDate;

  private Set<Long> seatIds;

  private Long userEntityId;

  private Long showtimeEntityId;

  public TicketDTO() {

  }

  public TicketDTO(final TicketEntity entity) {
    this.ticketId = entity.getTicketId();
    this.totalAmount = entity.getTotalAmount();
    this.bookingDate = entity.getBookingDate();
    if(entity.getSeats()!=null || entity.getSeats().size()>0) {
      entity.getSeats().stream().forEach(seat->{
        this.seatIds.add(seat.getSeatId());
      });
    }
    
    this.userEntityId = entity.getUser().getUserId();
    this.showtimeEntityId = entity.getShow().getShowTimeId();
  }

  public TicketEntity convert() {
    final TicketEntity entity = new TicketEntity();
    entity.setSeats(new HashSet<>());
    entity.setTotalAmount(this.totalAmount);
    entity.setBookingDate(this.bookingDate);
    if(this.seatIds!=null || this.seatIds.size()>0) {
      this.seatIds.stream().forEach(seat->{
        SeatEntity seatEntity = new SeatEntity();
        seatEntity.setSeatId(seat);
        entity.getSeats().add(seatEntity);
      });
    }
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

  public Set<Long> getSeats() {
    return seatIds;
  }

  public void setSeats(Set<Long> seatIds) {
    this.seatIds = seatIds;
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
