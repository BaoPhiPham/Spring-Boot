package com.chilllearn.loosecoupling.di.v3finalfantasy;

//rất giỏi gửi mail, 1 chuyện mà thôi
//Nguyên lí SRP - SINGLE RESPONSIBILITY PRINCIPLE
//Đơn trách nhiệm, 1 class chỉ tập trung 1 chủ thể: Email
//ôm thêm SMS, whatsAPP, vi phạm SRP
//
 //Tui gia nhập hội NOTI, thì t phải theo quy tắc hội, theo hợp đồng cam kết tuân thủ, CODE cho hàm ABSTRACT sendNoti()
//Và may mắn thay tui EMAIL-SENDER là thành viên NOTI-SERVICE, nay tui đc dùng, dùng đc ở Class SERVICE vì SERVICE chỉ chơi vơ NOTI
public class EmailSender implements NotiService {
    public void sendEmail(String recipient, String message){
        //TODO: LOGIC cử lý gửi email: SETUP ACCOUNT để đóng vai ng gửi (FROM - mình gửi, app gửi)
        //      FORMAT email cho PRO...
        //Thông báo thành công:
        System.out.println("(DI V3 - OCP)MAIL WAS SENT TO: " + recipient + " SUCCESSFULLY!!!\nEmail Contents: " + message);
    }
    @Override
    public void sendNoti(String to, String message){
        sendEmail(to, message);
    }

}
