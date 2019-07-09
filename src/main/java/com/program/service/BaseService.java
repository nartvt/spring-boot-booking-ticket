package com.program.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T,ID extends Serializable>{

  List<T> findAll();
  T findById(ID id);
  boolean insert(T model);
  boolean update(T model);
  boolean delete(ID id);
}
