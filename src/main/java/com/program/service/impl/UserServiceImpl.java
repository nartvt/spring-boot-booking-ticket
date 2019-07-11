package com.program.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.program.dto.UserDTO;
import com.program.entity.UserEntity;
import com.program.repository.UserRepository;
import com.program.service.UserService;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

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
  public  UserDTO findById(Long id) {
    final UserEntity entity = userRepository.findById(id).get();
    if(entity==null) {
      return null;
    }
    return new UserDTO(entity);
  }

  @Override
  public boolean insert(UserDTO model) {
    if (userRepository.findByEmail(model.getEmail()) != null
        || userRepository.findByPhoneNumber(model.getPhoneNumber()) != null) {
      return false;
    }
    userRepository.save(model.convert());
    return true;
  }

  @Override
  public boolean update(UserDTO model) {
    final UserEntity entity = userRepository.save(model.convert());
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
    userRepository.deleteById(id);
    return true;
  }

}
