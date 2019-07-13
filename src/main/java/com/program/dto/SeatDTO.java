package com.program.dto;

import com.program.entity.CinemaRoomEntity;
import com.program.entity.MovieTicketEntity;
import com.program.entity.SeatEntity;
import com.program.entity.SeatTypeEntity;

public class SeatDTO {

  private Long seatId;

  private String seatName;

  private Long room;

  private Long seatType;

  private Long ticket;

  public SeatDTO() {

  }

  public SeatDTO(final SeatEntity entity) {
    this.seatId = entity.getSeatId();
    this.seatName = entity.getSeatName();
    if (entity.getRoom().getRoomId() != null) {
      this.room = entity.getRoom().getRoomId();
    }
    if (entity.getSeatType().getSeatTypeId() != null) {
      this.seatType = entity.getSeatType().getSeatTypeId();
    }
    if (entity.getTicket().getTicketId() != null) {
      this.ticket = entity.getTicket().getTicketId();
    }

  }

  public SeatEntity convert() {
    final SeatEntity entity = new SeatEntity();
    entity.setSeatId(this.seatId);
    entity.setSeatName(this.seatName);

    CinemaRoomEntity cinemaRoomEntity = new CinemaRoomEntity();
    cinemaRoomEntity.setRoomId(this.room);
    entity.setRoom(cinemaRoomEntity);

    SeatTypeEntity seatTypeEntity = new SeatTypeEntity();
    seatTypeEntity.setSeatTypeId(this.seatType);
    entity.setSeatType(seatTypeEntity);

    MovieTicketEntity movieTicketEntity = new MovieTicketEntity();
    movieTicketEntity.setTicketId(this.ticket);
    entity.setTicket(movieTicketEntity);
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

  public Long getRoom() {
    return room;
  }

  public void setRoom(Long room) {
    this.room = room;
  }

  public Long getSeatType() {
    return seatType;
  }

  public void setSeatType(Long seatType) {
    this.seatType = seatType;
  }

  public Long getTicket() {
    return ticket;
  }

  public void setTicket(Long ticket) {
    this.ticket = ticket;
  }
}
