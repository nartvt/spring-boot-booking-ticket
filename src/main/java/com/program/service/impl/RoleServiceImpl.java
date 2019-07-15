package com.program.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.program.dto.RoleDTO;
import com.program.entity.RoleEntity;
import com.program.error.ResponseExceptionModel;
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
  public ResponseExceptionModel insert(RoleDTO model) {
    if (roleRepository.findById(model.getRoleId()) != null) {
      return new ResponseExceptionModel(Boolean.FALSE, "Role id  alreadly exists", HttpStatus.CONFLICT);
    }
    if (roleRepository.save(model.convert()) != null) {
      return new ResponseExceptionModel(Boolean.FALSE, "Can't add new role, something went wrong", HttpStatus.CONFLICT);
    } else {
      return new ResponseExceptionModel(Boolean.TRUE, "Success, new role created", HttpStatus.CONFLICT);
    }
  }

  @Override
  public ResponseExceptionModel update(RoleDTO model) {
    if (roleRepository.save(model.convert()) != null) {
      return new ResponseExceptionModel(Boolean.TRUE, "Role update Success", HttpStatus.OK);
    }
    return new ResponseExceptionModel(Boolean.FALSE, "can't update role, something went wrong",
        HttpStatus.UNPROCESSABLE_ENTITY);
  }

  @Override
  public ResponseExceptionModel delete(Long id) {
    if (id == null) {
      return new ResponseExceptionModel(Boolean.FALSE, "Id cannot be null", HttpStatus.BAD_REQUEST);
    }
    roleRepository.deleteById(id);
    return new ResponseExceptionModel(Boolean.TRUE, "Delete Success", HttpStatus.OK);
  }

}
