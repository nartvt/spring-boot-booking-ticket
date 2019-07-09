package com.program.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "Cinema")
public class CinemaEntity {
  @Id
  private String cinemaId;
  private String cinemaName;
  private String cinemaAddress;
  private String cinemaPhone;
  private String cinemaInfo;
  private String cinemaImage;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "cineplexId", nullable = false)
  private CineplexEntity cineplex;

  @OneToMany(mappedBy = "cinema")
  private Set<CinemaRoomEntity> cinemaRooms;

  public String getCinemaId() {
    return cinemaId;
  }

  public void setCinemaId(String cinemaId) {
    this.cinemaId = cinemaId;
  }

  public String getCinemaName() {
    return cinemaName;
  }

  public void setCinemaName(String cinemaName) {
    this.cinemaName = cinemaName;
  }

  public String getCinemaAddress() {
    return cinemaAddress;
  }

  public void setCinemaAddress(String cinemaAddress) {
    this.cinemaAddress = cinemaAddress;
  }

  public String getCinemaPhone() {
    return cinemaPhone;
  }

  public void setCinemaPhone(String cinemaPhone) {
    this.cinemaPhone = cinemaPhone;
  }

  public String getCinemaInfo() {
    return cinemaInfo;
  }

  public void setCinemaInfo(String cinemaInfo) {
    this.cinemaInfo = cinemaInfo;
  }

  public String getCinemaImage() {
    return cinemaImage;
  }

  public void setCinemaImage(String cinemaImage) {
    this.cinemaImage = cinemaImage;
  }

  public CineplexEntity getCineplex() {
    return cineplex;
  }

  public void setCineplex(CineplexEntity cineplex) {
    this.cineplex = cineplex;
  }

  public Set<CinemaRoomEntity> getCinemaRooms() {
    return cinemaRooms;
  }

  public void setCinemaRooms(Set<CinemaRoomEntity> cinemaRooms) {
    this.cinemaRooms = cinemaRooms;
  }

}
