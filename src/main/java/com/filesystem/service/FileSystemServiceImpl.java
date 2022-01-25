package com.filesystem.service;

import com.filesystem.model.File;
import com.filesystem.model.FileSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileSystemServiceImpl implements FileSystemService{

    @Override
    public List<String> ls(String path) {
        File t = FileSystem.getRoot();
        List<String> files = new ArrayList<>();
        if (!path.equals("/")) {
            String[] d = path.split("/");
            for (int i = 1; i < d.length; i++) {
                t = t.files.get(d[i]);
            }
            if (t.isFile) {
                files.add(d[d.length - 1]);
                return files;
            }
        }
        List<String> resFiles = new ArrayList<>(t.files.keySet());
        Collections.sort(resFiles);
        return resFiles;
    }

    @Override
    public void mkdir(String path) {
        File t = FileSystem.getRoot();
        String[] d = path.split("/");
        for (int i = 1; i < d.length; i++) {
            if (!t.files.containsKey(d[i]))
                t.files.put(d[i], new File());
            t = t.files.get(d[i]);
        }
    }

    @Override
    public void addContentToFile(String filePath, String content) {
        File t = FileSystem.getRoot();
        String[] d = filePath.split("/");
        for (int i = 1; i < d.length - 1; i++) {
            t = t.files.get(d[i]);
        }
        if (!t.files.containsKey(d[d.length - 1]))
            t.files.put(d[d.length - 1], new File());
        t = t.files.get(d[d.length - 1]);
        t.isFile = true;
        t.content = t.content + content;
    }

    @Override
    public String readContentFromFile(String filePath) {
        File t = FileSystem.getRoot();
        String[] d = filePath.split("/");
        for (int i = 1; i < d.length - 1; i++) {
            t = t.files.get(d[i]);
        }
        return t.files.get(d[d.length - 1]).content;
    }

    @Override
    public int countNumberOfFiles(String path){
        String[] d=path.split("/");
        int count=0;
        File temp = FileSystem.getRoot();
        for(int i=0;i<d.length;i++){
            if(temp.files!=null && temp.files.get(d[i])!=null){
                temp=temp.files.get(d[i]);
            }else{
                return 0;
            }
        }
        return temp.getNumberOfFiles();
    }

    @Override
    public void delete(String path){
        File t = FileSystem.getRoot();
        String[] d = path.split("/");
        for (int i = 1; i < d.length-1; i++) {
            t = t.files.get(d[i]);
        }
        File file = t.files.get(d[d.length-1]);
        if(file!=null) {
            t.files.remove(d[d.length-1]);
        }
    }
}
