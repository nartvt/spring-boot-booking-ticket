package com.program.dto;

import java.util.HashSet;
import java.util.Set;

import com.program.entity.CinemaRoomEntity;
import com.program.entity.TicketEntity;
import com.program.entity.SeatEntity;
import com.program.entity.SeatTypeEntity;

public class SeatDTO {

  private Long seatId;

  private String seatName;

  private Set<Long> rooms;

  private Long seatType;

  private Long ticket;

  public SeatDTO() {

  }

  public SeatDTO(final SeatEntity entity) {
    this.seatId = entity.getSeatId();
    this.seatName = entity.getSeatName();
    if (entity.getCinemaRooms() != null) {
      entity.getCinemaRooms().stream().forEach(room -> {
        this.rooms.add(room.getRoomId());
      });
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
    entity.setCinemaRooms(new HashSet<>());

    entity.setSeatName(this.seatName);

    if (this.rooms != null) {
      this.rooms.stream().forEach(room -> {
        CinemaRoomEntity cinemaRoomEntity = new CinemaRoomEntity();
        cinemaRoomEntity.setRoomId(room);
        entity.getCinemaRooms().add(cinemaRoomEntity);
      });

    }

    SeatTypeEntity seatTypeEntity = new SeatTypeEntity();
    seatTypeEntity.setSeatTypeId(this.seatType);
    entity.setSeatType(seatTypeEntity);

    TicketEntity ticketEntity = new TicketEntity();
    ticketEntity.setTicketId(this.ticket);
    entity.setTicket(ticketEntity);
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
