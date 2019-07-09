package com.program.dto;

import com.program.entity.CinemaRoomEntity;
import com.program.entity.SeatTypeEntity;

public class SeatTypeDTO {

  private Long seatTypeId;

  private String seatTypeName;

  private String description;

  private CinemaRoomEntity room;

  public SeatTypeDTO() {

  }

  public SeatTypeDTO(final SeatTypeEntity entity) {
    this.seatTypeId = entity.getSeatTypeId();
    this.seatTypeName = entity.getSeatTypeName();
    this.description = entity.getDescription();
    this.room = entity.getRoom();
  }

  public SeatTypeEntity convert() {
    final SeatTypeEntity entity = new SeatTypeEntity();
    entity.setSeatTypeId(this.seatTypeId);
    entity.setSeatTypeName(this.seatTypeName);
    entity.setDescription(this.description);
    entity.setRoom(this.room);
    return entity;
  }

  public Long getSeatTypeId() {
    return seatTypeId;
  }

  public void setSeatTypeId(Long seatTypeId) {
    this.seatTypeId = seatTypeId;
  }

  public String getSeatTypeName() {
    return seatTypeName;
  }

  public void setSeatTypeName(String seatTypeName) {
    this.seatTypeName = seatTypeName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public CinemaRoomEntity getRoom() {
    return room;
  }

  public void setRoom(CinemaRoomEntity room) {
    this.room = room;
  }
}
