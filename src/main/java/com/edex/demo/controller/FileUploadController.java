package com.edex.demo.controller;

//New IO package
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(path = "/resource")
public class FileUploadController {
    @Autowired
    private Environment env;
    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam final MultipartFile[] files) throws Exception{
        if(files.length != 0){
            for(MultipartFile file : files){
                String uploadLocation = env.getProperty("resources.uploads.location");
                Path path = Paths.get(uploadLocation + new Date().getTime() + file.getOriginalFilename());
                Files.write(path, file.getBytes());
            }
            return ResponseEntity.ok().body("File Upload Success!");
                 
        }else{
            return ResponseEntity.ok().body("Please Select a File!");
        }
    }
}
