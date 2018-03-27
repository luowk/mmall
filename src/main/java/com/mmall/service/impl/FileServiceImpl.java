package com.mmall.service.impl;


import com.google.common.collect.Lists;
import com.mmall.service.FileService;
import com.mmall.util.FTPUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service("fileService")
@Slf4j
public class FileServiceImpl implements FileService {

    @Override
    public String upload(MultipartFile file, String path) {
        String fileName = file.getOriginalFilename();
        //扩展名
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
        String uploadFileName = UUID.randomUUID().toString() + "." + fileExtensionName;
        log.info("开始上传文件，上传文件的文件名：{}，上传的路径：{}，新文件名：{}", fileName, path, uploadFileName);

        File fileDir = new File(path);
        if (!fileDir.exists()) {
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }

        File targetFile = new File(path, uploadFileName);
        try {
            file.transferTo(targetFile);//文件已经上传成功

            FTPUtil.uploadFile(Lists.newArrayList(targetFile));//将targetFile上传到FTP服务器

            targetFile.delete();//上传完成后，删除upload下面的文件
        } catch (IOException e) {
            log.error("上传文件异常");
            return null;
        }
        return targetFile.getName();
    }
}
