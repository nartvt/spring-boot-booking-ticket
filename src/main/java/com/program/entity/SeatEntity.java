package com.program.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name = "Seat")
public class SeatEntity {
  @Id
  private String seatId;
  private String seatName;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "roomId", nullable = false)
  private CinemaRoomEntity room;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "seatTypeId")
  private SeatTypeEntity seatType;

  @OneToOne(mappedBy = "seat")
  private MovieTicketEntity ticket;

  public String getSeatId() {
    return seatId;
  }

  public void setSeatId(String seatId) {
    this.seatId = seatId;
  }

  public String getSeatName() {
    return seatName;
  }

  public void setSeatName(String seatName) {
    this.seatName = seatName;
  }

  public CinemaRoomEntity getRoom() {
    return room;
  }

  public void setRoom(CinemaRoomEntity room) {
    this.room = room;
  }

  public SeatTypeEntity getSeatType() {
    return seatType;
  }

  public void setSeatType(SeatTypeEntity seatType) {
    this.seatType = seatType;
  }

  public MovieTicketEntity getTicket() {
    return ticket;
  }

  public void setTicket(MovieTicketEntity ticket) {
    this.ticket = ticket;
  }
  
  

}
