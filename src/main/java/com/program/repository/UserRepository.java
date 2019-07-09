package com.program.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.program.entity.UserEntity;

public interface UserRepository extends BaseRepository<UserEntity, String> {
  
  @Query(value = "SELECT u FROM UserEntity u")
  List<UserEntity> findAllUsers();

}
