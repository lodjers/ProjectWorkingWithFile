package com.example.ProjectWorkingWithFile.controllers;

import com.example.ProjectWorkingWithFile.beans.FileInfo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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

        String filePath = "C:\\Users\\danya\\Downloads";
        String fileFullPath = filePath + userFile.getOriginalFilename();
        File f = new File(fileFullPath);
        long unixTimeStamp = System.currentTimeMillis()/1000L;

        if (f.exists()) {
            String fileBkpPath = fileFullPath.replace(".", "_" + unixTimeStamp + ".");
            f.renameTo(new File(fileBkpPath));
        }
        userFile.transferTo(new File(fileFullPath));
        return fileInfo;
    }

    @PostMapping(value = "/fileUpload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public FileInfo fileUpload(@RequestParam("file") MultipartFile userFile) throws IOException {

        FileInfo fileInfo = new FileInfo();

        fileInfo.setFileName(userFile.getOriginalFilename());
        fileInfo.setContentType(userFile.getContentType());
        fileInfo.setFileLength(userFile.getSize());
        fileInfo.setFileEmpty(userFile.isEmpty());
        fileInfo.setReadable(userFile.getResource().isReadable());
        fileInfo.setFileData(userFile.getBytes());

        try {
            String filePath = "C:\\Users\\danya\\Downloads\\UploadedFiles";
            String fileName = userFile.getOriginalFilename();
            String entireFilePath = filePath + fileName;
            userFile.transferTo(new File(entireFilePath));
            fileInfo.setFileUploadStatus("Success");
        } catch (Exception e) {
            System.out.println(e);
            fileInfo.setFileUploadStatus("Failed " + e.getMessage());
        }

        return fileInfo;


    }
}
