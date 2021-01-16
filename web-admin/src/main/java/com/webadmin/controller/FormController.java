package com.webadmin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author lijichen
 * @date 2021/1/14 - 14:22
 */
@Slf4j
@Controller
public class FormController {
    @GetMapping("form_layouts")
    public String basic_table() {
        return "form/form_layouts";
    }


    //upload 文件上传
    @PostMapping("/upload")
    public String uplpad(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {

        log.info("email{},username{},headerImg{},photos{}",email,username,headerImg.getName(),photos.length);

        if (!headerImg.isEmpty()) {
            headerImg.transferTo(new File("D:\\headerImg\\" + headerImg.getOriginalFilename()));
        }

        if (photos.length > 0) {
            for (MultipartFile photo : photos) {
                if (!photo.isEmpty()){
                    photo.transferTo(new File("D:\\photos\\" + photo.getOriginalFilename()));
                }

            }
        }
        return "main";
    }
}
