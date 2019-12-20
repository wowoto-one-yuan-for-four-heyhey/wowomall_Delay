package com.xmu.wowoto.delay.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author MedalWill
 * @date 2019/12/20 10:56
 */
@Service
public interface PicService {
    String upload(MultipartFile file);
}
