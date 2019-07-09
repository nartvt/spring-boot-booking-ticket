package com.program.dto;

import com.program.entity.CinemaRoomEntity;
import com.program.entity.MovieTicketEntity;
import com.program.entity.SeatEntity;
import com.program.entity.SeatTypeEntity;

public class SeatDTO {

  private Long seatId;

  private String seatName;

  private CinemaRoomEntity room;

  private SeatTypeEntity seatType;

  private MovieTicketEntity ticket;

  public SeatDTO() {

  }

  public SeatDTO(final SeatEntity entity) {
    this.seatId = entity.getSeatId();
    this.seatName = entity.getSeatName();
    this.room = entity.getRoom();
    this.seatType = entity.getSeatType();
    this.ticket = entity.getTicket();
  }

  public SeatEntity convert() {
    final SeatEntity entity = new SeatEntity();
    entity.setSeatId(this.seatId);
    entity.setSeatName(this.seatName);
    entity.setRoom(this.room);
    entity.setSeatType(this.seatType);
    entity.setTicket(this.ticket);
    return entity;
  }

  public Long getSeatId() {
    return seatId;
  }

  public void setSeatId(Long seatId) {
    this.seatId = seatId;
  }

  public String getSeatName() {
    return seatName;
  }

  public void setSeatName(String seatName) {
    this.seatName = seatName;
  }

  public CinemaRoomEntity getRoom() {
    return room;
  }

  public void setRoom(CinemaRoomEntity room) {
    this.room = room;
  }

  public SeatTypeEntity getSeatType() {
    return seatType;
  }

  public void setSeatType(SeatTypeEntity seatType) {
    this.seatType = seatType;
  }

  public MovieTicketEntity getTicket() {
    return ticket;
  }

  public void setTicket(MovieTicketEntity ticket) {
    this.ticket = ticket;
  }
}
