package com.program.dto;

import com.program.entity.CinemaEntity;
import com.program.entity.CineplexEntity;

public class CinemaDTO {

  private Long cinemaId;

  private String cinemaName;

  private String cinemaAddress;

  private String cinemaPhone;

  private String cinemaInfo;

  private String cinemaImage;

  private Long cineplexEntity;

  public CinemaDTO() {

  }

  public CinemaDTO(final CinemaEntity entity) {
    this.cinemaId = entity.getCinemaId();
    this.cinemaName = entity.getCinemaName();
    this.cinemaAddress = entity.getCinemaAddress();
    this.cinemaPhone = entity.getCinemaPhone();
    this.cinemaInfo = entity.getCinemaInfo();
    this.cinemaImage = entity.getCinemaImage();
    this.cineplexEntity = entity.getCineplex().getCineplexId();
  }

  public CinemaEntity convert() {
    CinemaEntity entity = new CinemaEntity();
    entity.setCinemaName(this.cinemaName);
    entity.setCinemaPhone(this.cinemaPhone);
    entity.setCinemaInfo(this.cinemaInfo);
    entity.setCinemaAddress(this.cinemaAddress);
    
    CineplexEntity lCineplexEntity = new CineplexEntity();
    lCineplexEntity.setCineplexId(this.cineplexEntity);    
    entity.setCineplex(lCineplexEntity);
    return entity;
  }

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

  public Long getCineplex() {
    return cineplexEntity;
  }

  public void setCineplex(Long cineplex) {
    this.cineplexEntity = cineplex;
  }

}
