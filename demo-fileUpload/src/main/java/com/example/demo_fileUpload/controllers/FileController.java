package com.example.demo_fileUpload.controllers;

import com.example.demo_fileUpload.servicies.FileStorageService;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile file) throws IOException {
        return fileStorageService.upload(file);
    }
    @GetMapping("/download")
    /*public byte[] download(@RequestParam String file, HttpServletResponse response) throws IOException {
        String ext = FilenameUtils.getExtension(file);
        switch (ext){
            case "gif":
                response.setContentType(MediaType.IMAGE_GIF_VALUE);
                break;
            case "jpg":
            case "jpeg":
                response.setContentType(MediaType.IMAGE_JPEG_VALUE);
                break;
            case "png":
                response.setContentType(MediaType.IMAGE_PNG_VALUE);
                break;
        }
        response.setHeader("Content-Disposition", "attachment; filename=\""+file+"\"");
        return fileStorageService.download(file);
    }*/
    public ResponseEntity<byte[]> download(@RequestParam("file") MultipartFile file) throws IOException {
        String originalFileName = file.getOriginalFilename();
        String contentType = file.getContentType();
        byte[] content = file.getBytes();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(contentType));
        headers.setContentDispositionFormData(originalFileName, originalFileName);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

        return new ResponseEntity<>(content, headers, HttpStatus.OK);
    }

}
