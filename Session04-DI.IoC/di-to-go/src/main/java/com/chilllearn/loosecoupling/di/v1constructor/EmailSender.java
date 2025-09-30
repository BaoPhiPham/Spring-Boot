package com.chilllearn.loosecoupling.di.v1constructor;

public class EmailSender {
    //EmailSender rất giỏi vụ gửi mail
    //thảo SRP!!
    public void sendEMail(String recipient, String message){
        //TODO: LOGIC cử lý gửi email: SETUP ACCOUNT để đóng vai ng gửi (FROM - mình gửi, app gửi)
        //      FORMAT email cho PRO...
        //Thông báo thành công:
        System.out.println("(DI)MAIL WAS SENT TO: " + recipient + " SUCCESSFULLY!!!");
    }
}
