package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static LocalDateTime time = LocalDateTime.now();

    public static void main(String[] args) {
        createDir("E://Games", "src");
        createDir("E://Games", "res");
        createDir("E://Games", "savegames");
        createDir("E://Games", "temp");
        createDir("E://Games//src", "main");
        createDir("E://Games//src", "test");
        createDir("E://Games//res", "drawables");
        createDir("E://Games//res", "vectors");
        createDir("E://Games//res", "icons");
        createFile("E://Games//src//main//Main.java");
        createFile("E://Games//src//main//Utils.java");
        createFile("E://Games//temp//temp.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("E://Games//temp//temp.txt"))) {
            bw.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sb);
    }

    public static void createDir(String parentName, String dirName) {
        File dir = new File(parentName, dirName);
        if (dir.mkdir()) {
            sb.append(time)
                    .append(": ")
                    .append("Создан каталог ")
                    .append(dirName)
                    .append(" в каталоге ")
                    .append(parentName)
                    .append("\n");
        } else {
            sb.append(time)
                    .append(": ")
                    .append("Ошибка создания каталога ")
                    .append(dirName)
                    .append(" в каталоге ")
                    .append(parentName)
                    .append("\n");
        }
    }

    public static void createFile(String path) {
        File file = new File(path);
        try {
            if (file.createNewFile()) {
                sb.append(time)
                        .append(": ")
                        .append("Создан файл ")
                        .append(path)
                        .append("\n");
            } else {
                sb.append(time)
                        .append(": ")
                        .append("Ошибка создания файла ")
                        .append(path)
                        .append("\n");
            }
        } catch (IOException e) {
            sb.append(time)
                    .append(": ")
                    .append("При создании файла ")
                    .append(path)
                    .append(" возникло исключение ")
                    .append(" :\n")
                    .append(e.toString())
                    .append("\n");
        }
    }
}

