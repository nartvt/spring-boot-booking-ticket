package com.program.repository;

import org.springframework.stereotype.Repository;

import com.program.entity.CinemaRoomEntity;

@Repository
public interface CinemaRoomRepository extends BaseRepository<CinemaRoomEntity, Long> {
  CinemaRoomEntity findByRoomName(String name);
  
}
