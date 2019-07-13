package com.program.dto;

import com.program.entity.CinemaRoomEntity;
import com.program.entity.SeatTypeEntity;

public class SeatTypeDTO {

  private Long seatTypeId;

  private String seatTypeName;

  private String description;

  private Long room;

  public SeatTypeDTO() {

  }

  public SeatTypeDTO(final SeatTypeEntity entity) {
    this.seatTypeId = entity.getSeatTypeId();
    this.seatTypeName = entity.getSeatTypeName();
    this.description = entity.getDescription();
    if(entity.getRoom().getRoomId()!=null) {
      this.room = entity.getRoom().getRoomId();
    }
  }

  public SeatTypeEntity convert() {
    final SeatTypeEntity entity = new SeatTypeEntity();
    entity.setSeatTypeId(this.seatTypeId);
    entity.setSeatTypeName(this.seatTypeName);
    entity.setDescription(this.description);

    CinemaRoomEntity cinemaRoomEntity = new CinemaRoomEntity();
    cinemaRoomEntity.setRoomId(this.room);
    entity.setRoom(cinemaRoomEntity);
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

  public Long getRoom() {
    return room;
  }

  public void setRoom(Long room) {
    this.room = room;
  }
}
