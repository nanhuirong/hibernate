package com.huirong.model;

/**
 * Created by huirong on 17-5-16.
 */
public class SendMail implements Runnable {
    //定时发送电子邮件
    @Override
    public void run() {
        try {
            while (true){
                Thread.sleep(60 * 1000);
                //发送电子邮件
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
