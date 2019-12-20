package com.xmu.wowoto.delay.service.Impl;

import com.xmu.wowoto.delay.service.PicService;
import com.xmu.wowoto.delay.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

/**
 * @author MedalWill
 * @date 2019/12/20 11:02
 */
@Service
public class PicServicImpl implements PicService {

    @Autowired
    FileUploadUtil fileUploadUtil;

    @Value("${wowomall.host}")
    String host;

    @Value("${wowomall.port}")
    String port;

    @Override
    public String upload(MultipartFile file){
        String time= LocalDateTime.now().toString();

        String path=time+"_"+file.getOriginalFilename();
        String realpath="/var/java/upload/image/"+path;
        fileUploadUtil.fileUpload(file,realpath);
        return host+":"+port+"/image/"+path;
    }
}
