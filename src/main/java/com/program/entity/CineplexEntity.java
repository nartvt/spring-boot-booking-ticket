package com.program.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "Cineplex")
public class CineplexEntity {
  @Id
  private String cineplexId;
  private String cineplexName;
  private String cineplexLogo;

  @OneToMany(mappedBy = "cineplex")
  private Set<CinemaEntity> cinemas;

  public String getCineplexId() {
    return cineplexId;
  }

  public void setCineplexId(String cineplexId) {
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

  public Set<CinemaEntity> getCinemas() {
    return cinemas;
  }

  public void setCinemas(Set<CinemaEntity> cinemas) {
    this.cinemas = cinemas;
  }

}
