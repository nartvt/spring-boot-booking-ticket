package com.program.repository;

import org.springframework.stereotype.Repository;

import com.program.entity.RoleEntity;

@Repository
public interface RoleRepository extends BaseRepository<RoleEntity, Long> {
  RoleEntity findByRoleName(String name);
}
