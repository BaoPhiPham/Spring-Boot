package com.chilllearn.loosecoupling.di.v3finalfantasy;

import java.sql.SQLOutput;

//Mở cho thêm mới - OPEN FOR EXTENSION, mới hoàn toàn:
public class WhatsAppSender implements NotiService{

    @Override
    public void sendNoti(String to, String message) {
        System.out.println("(DI V3 - OCP): Instance WhatsApp message was sent to: " + to + "successfully!!!\nMessage contents: " + message);
    }
}
