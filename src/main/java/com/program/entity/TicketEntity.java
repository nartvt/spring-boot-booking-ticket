package com.program.entity;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TicketMovie")
public class TicketEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ticketId")
  private Long ticketId;

  @Column(name = "totalAmount")
  private Long totalAmount;

  @Column(name = "bookingDate")
  private Timestamp bookingDate;

  @OneToMany(mappedBy = "ticketEntity", 
      cascade = CascadeType.ALL,
      fetch = FetchType.LAZY,
      orphanRemoval = true)
  private Set<SeatEntity> seats;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "userId", nullable = true)
  private UserEntity user;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "showtimeId", nullable = false)
  private ShowtimeEntity show;

  public Long getTicketId() {
    return ticketId;
  }

  public void setTicketId(Long ticketId) {
    this.ticketId = ticketId;
  }

  public long getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(long totalAmount) {
    this.totalAmount = totalAmount;
  }

  public Timestamp getBookingDate() {
    return bookingDate;
  }

  public void setBookingDate(Timestamp bookingDate) {
    this.bookingDate = bookingDate;
  }

  public UserEntity getUser() {
    return user;
  }

  public TicketEntity setUser(UserEntity user) {
    this.user = user;
    return this;
  }

  public ShowtimeEntity getShow() {
    return show;
  }

  public TicketEntity setShow(ShowtimeEntity show) {
    this.show = show;
    return this;
  }

  public Set<SeatEntity> getSeats() {
    return seats;
  }

  public void setSeats(Set<SeatEntity> seats) {
    this.seats = seats;
  }

}
