package com.huirong.servlet.utils;

/**
 * Created by huirong on 17-5-18.
 */
public class MyTool {
    public static String getNewSttring(String str)throws Exception{
        return new String(str.getBytes("iso-8859-1"),
                "utf-8");
    }
}
