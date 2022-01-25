package com.filesystem.service;

import java.util.List;

public interface FileSystemService {
    void addContentToFile(String path, String content);
    String readContentFromFile(String path);
    void mkdir(String path);
    List<String> ls(String path);
    int countNumberOfFiles(String path);
    void delete(String path);
}
