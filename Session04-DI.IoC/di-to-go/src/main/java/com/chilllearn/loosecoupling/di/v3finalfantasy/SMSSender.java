package com.chilllearn.loosecoupling.di.v3finalfantasy;

//T rất giỏi gửi SMS
public class SMSSender implements NotiService {
    public void sendSMS(String phone, String message){
        //TODO: LOGIC cử lý gửi SMS: SETUP ACCOUNT để đóng vai ng gửi (FROM - mình gửi, app gửi)
        //      FORMAT SMS cho PRO...
        //Thông báo thành công:
        System.out.println("(DI V3 - OCP)SMS WAS SENT TO: " + phone + " SUCCESSFULLY!!!\nSMS Contents: " + message);
    }


    @Override// cam kết hợp đồng với CLUB
    public void sendNoti(String to, String message) {
        sendSMS(to, message);
    }
}
//EXTEENSION, code mới thêm, trc đó chưa có, có ngon ko sửa CLASS SERVICE!!!
