package com.program.dto;

import java.util.HashSet;
import java.util.Set;

import com.program.entity.CinemaRoomEntity;

public class CinemaRoomDTO {

  private Long roomId;

  private String roomName;

  private int quantitySeat;

  private Set<Long> cinemaEntitys;

  public CinemaRoomDTO() {
    
  }
  
  public CinemaRoomDTO(final CinemaRoomEntity entity) {
    this.roomId = entity.getRoomId();
    this.roomName = entity.getRoomName();
    this.quantitySeat = entity.getQuantitySeat();
   entity.getCinemas().stream().forEach(cinema->{
     this.cinemaEntitys.add(cinema.getCinemaId());
   });
  }
  
  public CinemaRoomEntity convert() {
    CinemaRoomEntity entity = new CinemaRoomEntity();
    entity.setCinemas(new HashSet<>());
    entity.setRoomName(this.roomName);
    entity.setQuantitySeat(this.quantitySeat);
    
    
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

  public Set<Long> getCinemas() {
    return cinemaEntitys;
  }

  public void setCinema(Set<Long> cinemaEntitys) {
    this.cinemaEntitys = cinemaEntitys;
  }
}
