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

@Entity(name = "Cinema")
public class CinemaEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="cinemaId")
  private Long cinemaId;
  
  @Column(name="cinemaName")
  private String cinemaName;
  
  @Column(name="cinemaAddress")
  private String cinemaAddress;
  
  @Column(name="cinemaPhone")
  private String cinemaPhone;
  
  @Column(name="cinemaInfo")
  private String cinemaInfo;
  
  @Column(name="cinemaImage")
  private String cinemaImage;

  @ManyToOne(fetch = FetchType.LAZY, optional = true)
  @JoinColumn(name = "cineplexId", nullable = true)
  private CineplexEntity cineplex;

  @JsonIgnore
  @OneToMany(mappedBy = "cinema",fetch = FetchType.LAZY)
  private Set<CinemaRoomEntity> cinemaRooms;

  public Long getCinemaId() {
    return cinemaId;
  }

  public void setCinemaId(Long cinemaId) {
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
