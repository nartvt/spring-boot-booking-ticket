package com.program.repository;

import org.springframework.stereotype.Repository;

import com.program.entity.SeatTypeEntity;

@Repository
public interface SeatTypeRepository extends BaseRepository<SeatTypeEntity, Long> {
  SeatTypeEntity findBySeatTypeName(String name);
}
