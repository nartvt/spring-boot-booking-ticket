package com.program.repository;

import org.springframework.stereotype.Repository;

import com.program.entity.UserEntity;

@Repository
public interface UserRepository extends BaseRepository<UserEntity, Long> {

  UserEntity findByEmail(String email);
  UserEntity findByPhoneNumber(String phoneNumber);
}
