package com.program.dto;

import com.program.entity.CineplexEntity;

public class CineplexDTO {

  private Long cineplexId;

  private String cineplexName;

  private String cineplexLogo;

  public CineplexDTO() {

  }

  public CineplexDTO(final CineplexEntity entity) {
    this.cineplexId = entity.getCineplexId();
    this.cineplexName = entity.getCineplexName();
    this.cineplexLogo = entity.getCineplexLogo();
  }
  
  public CineplexEntity convert() {
    final CineplexEntity entity = new CineplexEntity();
    entity.setCineplexId(this.cineplexId);
    entity.setCineplexName(this.cineplexName);
    entity.setCineplexLogo(this.cineplexLogo);
    return entity;
  }

  public Long getCineplexId() {
    return cineplexId;
  }

  public void setCineplexId(Long cineplexId) {
    this.cineplexId = cineplexId;
  }

  public String getCineplexName() {
    return cineplexName;
  }

  public void setCineplexName(String cineplexName) {
    this.cineplexName = cineplexName;
  }

  public String getCineplexLogo() {
    return cineplexLogo;
  }

  public void setCineplexLogo(String cineplexLogo) {
    this.cineplexLogo = cineplexLogo;
  }

}
