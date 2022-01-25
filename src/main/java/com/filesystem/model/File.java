package com.filesystem.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Set;

@Setter
@Getter
public class File {
    public boolean isFile = false;
    public HashMap<String, File> files = new HashMap<>();
    public String content = "";
    protected long created;
    protected long lastUpdated;
    protected long lastAccessed;
    File parent;
    private int size;

    public int getNumberOfFiles() {
        if(isFile){
            return 1;
        }else{
            Set<String> filesNames = files.keySet();
            int count=0;
            for (String filename:filesNames){
                File file = files.get(filename);
                count+=file.getNumberOfFiles();
            }
            return count;
        }
    }
}
