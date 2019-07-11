package com.program.file.service;

import com.program.file.exception.FileNotFoundException;
import com.program.file.exception.FileStorageException;
import com.program.file.model.FileInfoEntity;
import com.program.file.repository.FileRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Service
public class FileStorageService {

  @Autowired
  private FileRepository fileRepository;

  public FileInfoEntity storeFile(MultipartFile file) {
    // Normalize file name
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());

    try {
      // Check if the file's name contains invalid characters
      if (fileName.contains("..")) {
        throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
      }

      FileInfoEntity fileInfo = new FileInfoEntity(fileName, file.getContentType(),file.getSize(),  file.getBytes());

      return fileRepository.save(fileInfo);
    } catch (IOException ex) {
      throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
    }
  }

  public FileInfoEntity getFile(String fileId) {
    return fileRepository.findById(fileId)
        .orElseThrow(() -> new FileNotFoundException("File not found with id " + fileId));
  }
}
