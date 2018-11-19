package com.docker2.controller;

import com.docker2.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 文件相关接口
 * @author YETA
 * @date 2018/11/15/11:36
 */
@RestController
@RequestMapping(value = "/file")
public class FileController {

    @Autowired
    private FileService fileService;

    /**
     * 上传文件接口
     * @param multipartFile
     * @return
     * @throws IOException
     */
    @PostMapping(value = "/upload")
    public String upload(@RequestParam(value = "file", required = true) MultipartFile multipartFile) throws IOException {
        return fileService.upload(multipartFile);
    }
}
