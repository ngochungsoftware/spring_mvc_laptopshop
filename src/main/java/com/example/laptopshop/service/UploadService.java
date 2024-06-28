package com.example.laptopshop.service;

import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class UploadService {

    private final ServletContext servletContext;

    @Autowired
    public UploadService( ServletContext servletContext) {
        this.servletContext = servletContext;
    }

//    public String handleSaveUploadFile(MultipartFile file, String targetFolder) {
//        if (file.isEmpty()) {
//            return "";
//        }
//
//        String rootPath = this.servletContext.getRealPath("/resources/images");
//        String finalName = "";
//        try {
//            byte[] bytes = file.getBytes();
//
//            File dir = new File(rootPath + File.separator + "avatar");
//            if (!dir.exists()) {
//                dir.mkdir();
//            }
//
//            finalName = System.currentTimeMillis() + "-" + file.getOriginalFilename();
//
//            File serverFile = new File(dir.getAbsolutePath() + File.separator + finalName);
//            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
//            stream.write(bytes);
//            stream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return finalName;
//    }

    public String handleSaveUploadFile(MultipartFile file, String targetFolder) {
        // relative path: absolute path
        if (file.isEmpty()) {
            return "";
        }
        String rootPath = this.servletContext.getRealPath("/resources/images");
        String finalName = "";
        try {
            byte[] bytes = file.getBytes();

            File dir = new File(rootPath + File.separator + targetFolder);
            if (!dir.exists())
                dir.mkdirs();

            // Create the file on server
            finalName = System.currentTimeMillis() + "-" + file.getOriginalFilename();

            File serverFile = new File(dir.getAbsolutePath() + File.separator + finalName);
            // uuid

            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(serverFile));
            stream.write(bytes);
            stream.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return finalName;
    }
}
