package com.program.repository;

import org.springframework.stereotype.Repository;

import com.program.entity.TicketEntity;

@Repository
public interface MovieTicketRepository extends BaseRepository<TicketEntity, Long> {

}
