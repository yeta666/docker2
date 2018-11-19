package com.docker2.service;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 文件相关服务实现
 * @author YETA
 * @date 2018/11/15/15:18
 */
@Service
public class FileService {

    public String upload(MultipartFile multipartFile) throws IOException {
        //开发环境：获取项目根目录
        File path = new File(ResourceUtils.getURL("classpath:").getPath());
        //生产环境：获取jar包所在目录
        if (!path.exists()) {
            path = new File("");
        }
        File upload = new File(path.getAbsolutePath(), "upload/");
        if (!upload.exists()) {
            upload.mkdir();
        }
        File file = new File(upload, System.currentTimeMillis() + multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf(".")));
        multipartFile.transferTo(file);
        return file.getAbsolutePath();
    }
}
