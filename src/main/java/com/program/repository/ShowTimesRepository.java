package com.program.repository;

import org.springframework.stereotype.Repository;

import com.program.entity.ShowtimeEntity;

@Repository
public interface ShowTimesRepository extends BaseRepository<ShowtimeEntity, Long> {

}
