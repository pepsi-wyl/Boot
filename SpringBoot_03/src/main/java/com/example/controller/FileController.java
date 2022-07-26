package com.example.controller;

import com.example.service.fileService.FileService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;

/**
 * @author by pepsi-wyl
 * @date 2022-03-13 13:45
 */

@Slf4j
@Controller("fileController")
public class FileController {

    final FileService fileService;

    public FileController(@Qualifier(value = "fileService") FileService fileService) {
        this.fileService = fileService;
    }

    // MultipartFile 自动封装上传过来的文件
    @ResponseBody
    @PostMapping("/upload")
    public String upload(
            @RequestPart("file") MultipartFile file,
            @RequestPart("files") MultipartFile[] files
    ) {
        // 创建 服务器上传的路径
        File realPath = new File("G:\\idea\\Boot\\SpringBoot_03\\src\\main\\resources\\static\\file");
        if (!realPath.exists()) realPath.mkdir();

        fileService.uploadFile(realPath, file);
        fileService.uploadFiles(realPath, files);
        return "success";
    }

    // 使用ResponseEntity实现下载文件的功能
    @RequestMapping(value = "/down")
    public ResponseEntity<byte[]> down(HttpSession session) {
        File realPath = new File("G:\\idea\\Boot\\SpringBoot_03\\src\\main\\resources\\static\\file");
        String fileName = "favicon.ico";
        return fileService.down(realPath, fileName);
    }


}
