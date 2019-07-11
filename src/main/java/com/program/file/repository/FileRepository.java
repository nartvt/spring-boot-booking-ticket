package com.program.file.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.program.file.model.FileInfoEntity;

@Repository
public interface FileRepository extends JpaRepository<FileInfoEntity, String> {

}
