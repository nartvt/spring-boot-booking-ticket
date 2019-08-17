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
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "Seat")
public class SeatEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "seatId")
  private Long seatId;

  @Column(name = "seatName")
  private String seatName;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "seatTypeId", nullable = false)
  private SeatTypeEntity seatType;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "ticketId")
  private TicketEntity ticketEntity;

  @JsonIgnore
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "CinemaSeat", joinColumns = @JoinColumn(name = "seatId", referencedColumnName = "seatId"), inverseJoinColumns = @JoinColumn(name = "roomId", referencedColumnName = "roomId"))
  private Set<CinemaRoomEntity> cinemaRooms;

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

  public SeatTypeEntity getSeatType() {
    return seatType;
  }

  public void setSeatType(SeatTypeEntity seatType) {
    this.seatType = seatType;
  }

  public TicketEntity getTicket() {
    return ticketEntity;
  }

  public void setTicket(TicketEntity ticketEntity) {
    this.ticketEntity = ticketEntity;
  }

  public Set<CinemaRoomEntity> getCinemaRooms() {
    return cinemaRooms;
  }

  public void setCinemaRooms(Set<CinemaRoomEntity> cinemaRooms) {
    this.cinemaRooms = cinemaRooms;
  }

}
