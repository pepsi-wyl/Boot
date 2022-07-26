package com.example.service.fileService;

import lombok.SneakyThrows;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.UUID;

/**
 * @author by pepsi-wyl
 * @date 2022-03-13 14:58
 */

@Service(value = "fileService")
public class FileServiceImpl implements FileService {

    @Override
    @SneakyThrows
    public ResponseEntity<byte[]> down(File realPath, String fileName) {
        InputStream input = new FileInputStream(new File(realPath, fileName)); //创建输入流
        byte[] bytes = new byte[input.available()];//创建字节数组
        input.read(bytes); //将流读到字节数组中

        MultiValueMap<String, String> headers = new HttpHeaders(); //创建HttpHeaders对象设置响应头信息
        headers.add("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8")); //设置要下载方式以及下载文件的名字
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, HttpStatus.OK); //创建ResponseEntity对象
        input.close(); //关闭输入流
        return responseEntity;
    }

    @Override
    @SneakyThrows
    public Boolean uploadFile(File realPath, MultipartFile file) {
        // 单文件上传
        if (!file.isEmpty()) {
            // 保存到文件服务器
            String filename = file.getOriginalFilename();
            file.transferTo(new File(realPath + File.separator + UUID.randomUUID().toString() + filename.substring(filename.lastIndexOf("."))));
            return true;
        }
        return false;
    }

    @Override
    @SneakyThrows
    public Boolean uploadFiles(File realPath, MultipartFile[] files) {
        // 多文件上传
        if (files.length > 0) {
            for (MultipartFile multipartFile : files) {
                String filename = multipartFile.getOriginalFilename();
                multipartFile.transferTo(new File(realPath + File.separator + UUID.randomUUID().toString() + filename.substring(filename.lastIndexOf("."))));
            }
            return true;
        }
        return false;
    }

}
