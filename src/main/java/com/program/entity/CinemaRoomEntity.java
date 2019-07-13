package com.program.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "CinemaRoom")
public class CinemaRoomEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "roomId")
  private Long roomId;

  @Column(name = "roomName")
  private String roomName;

  @Column(name = "quantitySeat")
  private int quantitySeat;

  @ManyToOne(fetch = FetchType.LAZY, optional = true)
  @JoinColumn(name = "cinemaId", nullable = true)
  private CinemaEntity cinema;

  @JsonIgnore
  @OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
  private Set<SeatEntity> seat;

  public CinemaRoomEntity() {
    
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

  public Set<SeatEntity> getSeat() {
    return seat;
  }

  public void setSeat(Set<SeatEntity> seat) {
    this.seat = seat;
  }

}
