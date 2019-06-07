package com.bms.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FileUtil {
    /**
     * 读取文件
     *
     * @param filePath 文件路径
     * @return 文件内容
     */
    public static String readFile(String filePath) {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader reader = new FileReader(filePath);
             BufferedReader br = new BufferedReader(reader)) {
            String line;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line);
                System.out.println(line);
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            System.out.println("readFile：" + e.getLocalizedMessage());
        }
        return null;
    }

    public static List<String> readFileList(String filePath) {
        try (FileReader reader = new FileReader(filePath);
             BufferedReader br = new BufferedReader(reader)) {
            List<String> result = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                result.add(line);
            }
            return result;
        } catch (IOException e) {
            System.out.println("readFile：" + e.getLocalizedMessage());
        }
        return null;
    }

    public static List<String> readFileList(String filePath, int ignoreLine) {
        try (FileReader reader = new FileReader(filePath);
             BufferedReader br = new BufferedReader(reader)) {
            List<String> result = new ArrayList<>();
            String line;
            int currentLine = 0;
            while ((line = br.readLine()) != null) {
                if (currentLine == ignoreLine) {
                    continue;
                }
                result.add(line);
                currentLine++;
            }
            return result;
        } catch (IOException e) {
            System.out.println("readFile：" + e.getLocalizedMessage());
        }
        return null;
    }

    public static String readFile(String filePath, int onlyLine) {
        try (FileReader reader = new FileReader(filePath);
             BufferedReader br = new BufferedReader(reader)) {
            String line;
            int currentLine = 0;
            while ((line = br.readLine()) != null) {
                if (currentLine == onlyLine) {
                    return line;
                }
            }
            return "";
        } catch (IOException e) {
            System.out.println("readFile：" + e.getLocalizedMessage());
        }
        return null;
    }

    /**
     * 创建新文件写入
     *
     * @param filePath 文件路径
     * @param contents 要写入的内容
     * @return 是否写入成功
     */
    public static boolean writeNewFile(String filePath, List<String> contents) {
        try (FileWriter writer = new FileWriter(filePath);
             BufferedWriter bw = new BufferedWriter(writer)) {
            for (String content : contents) {
                bw.write(content);
                bw.newLine();
            }
            return true;
        } catch (IOException e) {
            System.out.println("writeNewFile：" + e.getLocalizedMessage());
        }
        return false;
    }

    /**
     * 没有文件就创建文件写入，有就追加到文件的后面写入
     *
     * @param filePath 文件路径
     * @param contents 要写入的内容
     * @return 是否写入成功
     */
    public static boolean writeAppendFile(String filePath, List<String> contents) {
        try (FileWriter writer = new FileWriter(filePath, true);
             BufferedWriter bw = new BufferedWriter(writer)) {
            for (String content : contents) {
                bw.append(content);
                bw.newLine();
            }
            return true;
        } catch (IOException e) {
            System.out.println("writeAppendFile：" + e.getLocalizedMessage());
        }
        return false;
    }

    /**
     * 没有文件就创建文件写入，有就追加到文件的后面写入
     *
     * @param filePath 文件路径
     * @param content 要写入的内容
     * @return 是否写入成功
     */
    public static boolean writeAppendFile(String filePath, String content) {
        try (FileWriter writer = new FileWriter(filePath, true);
             BufferedWriter bw = new BufferedWriter(writer)) {
            bw.append(content);
            bw.newLine();
            return true;
        } catch (IOException e) {
            System.out.println("writeAppendFile：" + e.getLocalizedMessage());
        }
        return false;
    }

}
