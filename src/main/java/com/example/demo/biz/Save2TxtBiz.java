package com.example.demo.biz;

import java.io.*;

public class Save2TxtBiz {
    public static String FILE_PATH = "C:\\Users\\Administrator\\Desktop\\test\\";
    public static boolean save(String content,String fileName){
        String path = FILE_PATH + fileName;
        File file = new File(path);
        //创建文件
        if(!file.exists()){
            try {
                file.createNewFile();

            }catch (IOException e){
                e.printStackTrace();
            }
        }

        return write2Txt(content,path);
    }

    //写入txt
    public static boolean write2Txt(String content,String path){
        File file = new File(path);
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        String temp = "";
        try {
            fileInputStream = new FileInputStream(file);

            inputStreamReader = new InputStreamReader(fileInputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0;(temp = bufferedReader.readLine()) != null;i ++){
                stringBuffer.append(temp);
                stringBuffer.append(System.getProperty("ling.separator"));
            }
            stringBuffer.append(content + "\r\n");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            PrintWriter printWriter = new PrintWriter(fileOutputStream);
            printWriter.write(stringBuffer.toString().toCharArray());
            printWriter.flush();
        }catch (IOException e){
            e.printStackTrace();
        }

        return true;
    }
}
