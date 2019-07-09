package com.program.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "Cineplex")
public class CineplexEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "cineplexId")
  private Long cineplexId;

  @Column(name = "cineplexName")
  private String cineplexName;

  @Column(name = "cineplexLogo")
  private String cineplexLogo;

  @JsonIgnore
  @OneToMany(mappedBy = "cineplex", fetch = FetchType.LAZY)
  private Set<CinemaEntity> cinemas;

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

  public Set<CinemaEntity> getCinemas() {
    return cinemas;
  }

  public void setCinemas(Set<CinemaEntity> cinemas) {
    this.cinemas = cinemas;
  }

}
