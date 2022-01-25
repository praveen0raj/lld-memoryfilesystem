package com.filesystem.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Setter
@Getter
public class File {
    public boolean isFile = false;
    public HashMap<String, File> files = new HashMap<>();
    public String content = "";
}
