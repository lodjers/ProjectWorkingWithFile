package com.example.ProjectWorkingWithFile.controllers;

import com.example.ProjectWorkingWithFile.beans.FileInfo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class UserFilesController {

    @PostMapping(value = "/getFileInfo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public FileInfo getFileInfo(@RequestParam("file") MultipartFile userFile) throws IOException {
        FileInfo fileInfo = new FileInfo();

        fileInfo.setFileName(userFile.getOriginalFilename());
        fileInfo.setContentType(userFile.getContentType());
        fileInfo.setFileLength(userFile.getSize());
        fileInfo.setFileEmpty(userFile.isEmpty());
        fileInfo.setReadable(userFile.getResource().isReadable());
        fileInfo.setFileData(userFile.getBytes());

        return fileInfo;
    }
}
