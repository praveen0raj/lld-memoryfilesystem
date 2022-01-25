package com.filesystem.model;

public class FileSystem {

    private static FileSystem fs = new FileSystem();

    File root = new File();

    public static FileSystem getFileSystem(){
        return fs;
    }

    public File getRoot() {
        return root;
    }
}
