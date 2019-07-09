package com.program.repository;

import org.springframework.stereotype.Repository;

import com.program.entity.MovieTicketEntity;

@Repository
public interface MovieTicketRepository extends BaseRepository<MovieTicketEntity, Long> {

}
