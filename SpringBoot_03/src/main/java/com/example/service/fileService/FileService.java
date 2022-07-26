package com.example.service.fileService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author by pepsi-wyl
 * @date 2022-03-13 14:56
 */

public interface FileService {

    ResponseEntity<byte[]> down(File realPath, String fileName);
    Boolean uploadFile(File realPath, MultipartFile file);
    Boolean uploadFiles(File realPath, MultipartFile[] files);

}
