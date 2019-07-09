package com.program.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "CinemaRoom")
public class CinemaRoomEntity {
  @Id
  private String roomId;
  private String roomName;
  private int seatAmount;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "cinemaId", nullable = false)
  private CinemaEntity cinema;

  @OneToMany(mappedBy = "room")
  private Set<SeatEntity> seat;

  public String getRoomId() {
    return roomId;
  }

  public void setRoomId(String roomId) {
    this.roomId = roomId;
  }

  public String getRoomName() {
    return roomName;
  }

  public void setRoomName(String roomName) {
    this.roomName = roomName;
  }

  public int getSeatAmount() {
    return seatAmount;
  }

  public void setSeatAmount(int seatAmount) {
    this.seatAmount = seatAmount;
  }

  public CinemaEntity getCinema() {
    return cinema;
  }

  public void setCinema(CinemaEntity cinema) {
    this.cinema = cinema;
  }

  public Set<SeatEntity> getSeat() {
    return seat;
  }

  public void setSeat(Set<SeatEntity> seat) {
    this.seat = seat;
  }

}
