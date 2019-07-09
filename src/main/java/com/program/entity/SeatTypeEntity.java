package com.program.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "SeatType")
public class SeatTypeEntity {

  @Id
  private String seatTypeId;
  private String seatTypeName;
  private String description;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "roomId", nullable = false)
  private CinemaRoomEntity room;

  @OneToMany(mappedBy = "seatType", cascade = CascadeType.ALL)
  private  Set<SeatEntity> seats;

  public String getSeatTypeId() {
    return seatTypeId;
  }

  public void setSeatTypeId(String seatTypeId) {
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

  public Set<SeatEntity> getSeats() {
    return seats;
  }

  public void setSeats(Set<SeatEntity> seats) {
    this.seats = seats;
  }
  
}
