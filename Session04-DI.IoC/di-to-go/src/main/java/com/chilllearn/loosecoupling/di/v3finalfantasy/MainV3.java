package com.chilllearn.loosecoupling.di.v3finalfantasy;


public class MainV3 {
    public static void main(String[] args) {
        //gửi mail confirm khi đang kí:
        EmailSender emailSender = new EmailSender();

        //DÙng SERVICE để gửi:
        UserService userService = new UserService(emailSender);//Tiêm email vào qua CONSTRUCTOR
        userService.registerAccount("HoangNgocChing@gmail.com", "OTP via email");

        //Muốn gửi qua SMS:
        SMSSender smssender = new SMSSender();
        //Chích vào service trên qua set, ko new userService mới
        userService.setNotiService(smssender);
        userService.registerAccount("0986.66.6789", "Confirm OTP 8386 please");

        WhatsAppSender whatsAppSender = new WhatsAppSender();
        //Ko thèm sửa SERVICE, chơi với tương lai
        //CLOSED FOR NOTIFICATION
        userService.setNotiService(whatsAppSender);//chơi với tương lai, ko sửa code cũ SERVICE, hard-coded là toang, phải sửa code nhìu nơi
        userService.registerAccount("+1-225-555-1002", "OTP: 2204");

        //Gửi tin nhắn qua Telegram, Discord!!!
        //Lẽ Thường: code thêm CLASS lẻ - CONCRETE CLASS và IMPLEMENTS NOTI-SERVICE
        //PRO: CLASS ON THE GO, TAKE AWAY, ANONYMOUS CLASS
        //NEW luôn INTERFACE, ăn đòn, IMPLEMENTS ngay CODE ngay lúc NEW INTERFACE
        NotiService telegram = new NotiService() {
            @Override
            public void sendNoti(String to, String message) {
                System.out.println("(DI V3 - OCP, ANNONYMUS CLASS): Instance Telegram message was sent to: " + to + "successfully!!!\nMessage contents: " + message);
            }
        };//đừng quên chấm phẩy
        //Gửi Confirm:
        userService.setNotiService(telegram);
        userService.registerAccount("hoangngocchinh","DI, INTERFACE MÃI ĐỈNH!!!");
    }


}
