package com.program.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.program.conmmon.RoleEnum;
import com.program.dto.UserDTO;
import com.program.entity.UserEntity;
import com.program.error.ResponseExceptionModel;
import com.program.repository.UserRepository;
import com.program.service.UserService;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  private ResponseExceptionModel responseExceptionModel;

  @Override
  public List<UserDTO> findAll() {
    final List<UserEntity> entitys = userRepository.findAll();
    if (entitys != null) {
      final List<UserDTO> userDTOs = Lists.newArrayList();
      entitys.forEach(entity -> {
        final UserDTO dto = new UserDTO(entity);
        userDTOs.add(dto);
      });
      return userDTOs;
    }

    return Lists.newArrayList();
  }

  @Override
  public UserDTO findById(Long id) {
    final UserEntity entity = userRepository.findById(id).get();
    if (entity == null) {
      return null;
    }
    return new UserDTO(entity);
  }

  @Override
  public ResponseExceptionModel insert(UserDTO model) {
    if (userRepository.findByEmail(model.getEmail()) != null
        || userRepository.findByPhoneNumber(model.getPhoneNumber()) != null) {
      return new ResponseExceptionModel(Boolean.FALSE, "email or phone number alreadly exists", HttpStatus.CONFLICT);
    }
    userRepository.save(model.convert());
    return new ResponseExceptionModel(Boolean.TRUE, "Add success", HttpStatus.CREATED);
  }

  @Override
  public ResponseExceptionModel update(UserDTO model) {

    model.setRole(RoleEnum.ROLE_USER.ID());
    if (userRepository.save(model.convert()) != null) {
      return new ResponseExceptionModel(Boolean.TRUE, "Update Success", HttpStatus.OK);
    }
    return new ResponseExceptionModel(Boolean.FALSE, "Can't add user", HttpStatus.UNPROCESSABLE_ENTITY);
  }

  @Override
  public ResponseExceptionModel delete(Long id) {
    if (id == null) {
      return new ResponseExceptionModel(Boolean.FALSE, "Delete un success", HttpStatus.NOT_ACCEPTABLE);
    }
    userRepository.deleteById(id);
    return new ResponseExceptionModel(Boolean.TRUE, "Delete success", HttpStatus.OK);
  }

}
