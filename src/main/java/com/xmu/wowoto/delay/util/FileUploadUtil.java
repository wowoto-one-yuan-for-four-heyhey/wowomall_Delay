package com.xmu.wowoto.delay.util;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class FileUploadUtil {
    public String fileUpload(MultipartFile file, String path) {
        if (!file.isEmpty()) {
            try {
                BufferedOutputStream out = new    BufferedOutputStream(new FileOutputStream(new File(path)));
                System.out.println(file.getOriginalFilename());
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            }

            return "上传成功.";

        } else {
            return "上传失败，文件是空的.";
        }
    }
}
