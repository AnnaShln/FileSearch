package com.anna;

import java.io.*;


public class Main {

    public static void main(String[] args) {
        CommandLineArgument values = new CommandLineArgument(args);
        System.out.println("Enter a line: find [-r] [-d directory] filename.txt");
        System.out.println(fileSearch(values.getName(), values.getKeyDir(), values.isKeySubDir()));
    }

    public static String fileSearch(String name, String dir, boolean subDir) {
        String path = "Файл не найден";
        File wantedDir = new File(dir);
        File[] list = wantedDir.listFiles();
        if (list == null) return path;
        if (subDir) {
            for (File f : list) {
                if (f.isFile() && f.getName().equals(name)) {
                    path = f.getPath();
                    break;
                }
                if (f.isDirectory()) {
                    path = fileSearch(name, dir+"\\"+f.getName(), true);
                    if (path != "Файл не найден") break;
                }
            }
        } else {
            File[] listOfFiles = wantedDir.listFiles(file -> file.getName().equals(name));
            if (listOfFiles == null) return path;
            for (File t : listOfFiles) {
                path = t.getPath();
            }

        }
        return path;
    }
}
