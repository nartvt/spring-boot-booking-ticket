package com.program.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.program.dto.RoleDTO;
import com.program.entity.RoleEntity;
import com.program.repository.RoleRepository;
import com.program.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

  @Autowired
  private RoleRepository roleRepository;

  @Override
  public List<RoleDTO> findAll() {
    final List<RoleEntity> entitys = roleRepository.findAll();
    if (entitys != null) {
      final List<RoleDTO> roleDTOs = Lists.newArrayList();
      entitys.forEach(entity -> {
        final RoleDTO dto = new RoleDTO(entity);
        roleDTOs.add(dto);
      });
      return roleDTOs;
    }

    return Lists.newArrayList();
  }

  @Override
  public RoleDTO findById(Long id) {
    final RoleEntity entity = roleRepository.findById(id).get();
    return new RoleDTO(entity);
  }

  @Override
  public boolean insert(RoleDTO model) {
    if (roleRepository.findByRoleName(model.getRoleName()) != null) {
      return false;
    }
    roleRepository.save(model.convert());
    return true;
  }

  @Override
  public boolean update(RoleDTO model) {
    final RoleEntity entity = roleRepository.save(model.convert());
    if (entity == null) {
      return false;
    }
    return true;
  }

  @Override
  public boolean delete(Long id) {
    if (id == null) {
      return false;
    }
    roleRepository.deleteById(id);
    return true;
  }

}
