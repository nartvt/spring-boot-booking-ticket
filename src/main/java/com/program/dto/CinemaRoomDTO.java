package com.program.dto;

import com.program.entity.CinemaEntity;
import com.program.entity.CinemaRoomEntity;

public class CinemaRoomDTO {

  private Long roomId;

  private String roomName;

  private int quantitySeat;

  private CinemaEntity cinema;

  public CinemaRoomDTO() {
    
  }
  
  public CinemaRoomDTO(final CinemaRoomEntity entity) {
    this.roomId = entity.getRoomId();
    this.roomName = entity.getRoomName();
    this.quantitySeat = entity.getQuantitySeat();
    this.cinema = entity.getCinema();
  }
  
  public CinemaRoomEntity convert() {
    CinemaRoomEntity entity = new CinemaRoomEntity();
    entity.setRoomId(this.roomId);
    entity.setRoomName(this.roomName);
    entity.setQuantitySeat(this.quantitySeat);
    entity.setCinema(this.cinema);
    return entity;
  }
  
  public Long getRoomId() {
    return roomId;
  }

  public void setRoomId(Long roomId) {
    this.roomId = roomId;
  }

  public String getRoomName() {
    return roomName;
  }

  public void setRoomName(String roomName) {
    this.roomName = roomName;
  }

  public int getQuantitySeat() {
    return quantitySeat;
  }

  public void setQuantitySeat(int quantitySeat) {
    this.quantitySeat = quantitySeat;
  }

  public CinemaEntity getCinema() {
    return cinema;
  }

  public void setCinema(CinemaEntity cinema) {
    this.cinema = cinema;
  }
}
