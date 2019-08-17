package com.program.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "CinemaRoom")
public class CinemaRoomEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "roomId")
  private Long roomId;

  @Column(name = "roomName")
  private String roomName;

  @Column(name = "quantitySeat")
  private int quantitySeat;

  
  @JsonIgnore
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "CinemaRoomCinema",
  joinColumns = @JoinColumn(name="roomId", referencedColumnName = "roomId"),
  inverseJoinColumns = @JoinColumn(name="cinemaId",referencedColumnName = "cinemaId"))
  private Set<CinemaEntity> cinemas;
  

  @JsonIgnore
  @ManyToMany(mappedBy = "cinemaRooms", fetch = FetchType.LAZY)
  private Set<SeatEntity> seats;
  
  

  public Set<CinemaEntity> getCinemas() {
    return cinemas;
  }

  public void setCinemas(Set<CinemaEntity> cinemas) {
    this.cinemas = cinemas;
  }

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

  public Set<SeatEntity> getSeats() {
    return seats;
  }

  public void setSeats(Set<SeatEntity> seat) {
    this.seats = seat;
  }

}
