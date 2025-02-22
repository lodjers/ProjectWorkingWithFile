package com.example.ProjectWorkingWithFile.beans;

import lombok.Data;



public class FileInfo {

    private String fileName;

    private Long fileLength;

    private String contentType;

    private Boolean isReadable;

    private Boolean isFileEmpty;

    private byte[] fileData;


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getFileLength() {
        return fileLength;
    }

    public void setFileLength(Long fileLength) {
        this.fileLength = fileLength;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Boolean getReadable() {
        return isReadable;
    }

    public void setReadable(Boolean readable) {
        isReadable = readable;
    }

    public Boolean getFileEmpty() {
        return isFileEmpty;
    }

    public void setFileEmpty(Boolean fileEmpty) {
        isFileEmpty = fileEmpty;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }
}
