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

@Entity(name = "SeatType")
public class SeatTypeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "seatTypeId")
  private Long seatTypeId;

  @Column(name = "seatTypeName")
  private String seatTypeName;

  @Column(name = "description")
  private String description;

  @ManyToOne(fetch = FetchType.LAZY, optional = true)
  @JoinColumn(name = "roomId", nullable = true)
  private CinemaRoomEntity room;

  @JsonIgnore
  @OneToMany(mappedBy = "seatType", fetch = FetchType.LAZY)
  private Set<SeatEntity> seats;

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

  public Set<SeatEntity> getSeats() {
    return seats;
  }

  public void setSeats(Set<SeatEntity> seats) {
    this.seats = seats;
  }

}
