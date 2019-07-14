package com.program.service;

import java.io.Serializable;
import java.util.List;

import com.program.error.ResponseExceptionModel;

public interface BaseService<T,ID extends Serializable>{

  List<T> findAll();
  T findById(ID id);
  ResponseExceptionModel insert(T model);
  ResponseExceptionModel update(T model);
  ResponseExceptionModel delete(ID id);
}
