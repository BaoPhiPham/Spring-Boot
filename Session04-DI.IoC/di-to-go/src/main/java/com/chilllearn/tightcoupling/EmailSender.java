package com.chilllearn.tightcoupling;

public class EmailSender {

    //Tui là gã rất giỏi chuyên gửi EMAIL, tui ko dính dáng gì đến SMS, WHATSAPP, TELEGRAM. Tui thỏa nguyên lí S/SRP trong S.O.L.I.D
    //TUI chỉ chứa hàm, nhiều hàm chuyên liên quan EMAIL - 1 chủ thể
    //Sau này nâng cấp code th cx chỉ là xoay quang EMAIL, 1 lí do/chủ thể sửa đổi mà thôi

    //Hàm này gửi mail tới ng dnag98 kí account, thông tin email nhập từ màn hình đăng kí, đi qua Controller đến service đến đây !!!
    //email của user đăng kí nằm trong Account entity(đơn giản), nằm trong AccountDto(bản cắt bớt của field từ Entity)
    //                           to:                nội dung mail
    public void sendEMail(String recipient, String message){
        //TODO: LOGIC cử lý gửi email: SETUP ACCOUNT để đóng vai ng gửi (FROM - mình gửi, app gửi)
        //      FORMAT email cho PRO...
        //Thông báo thành công:
        System.out.println("MAIL WAS SENT TO: " + recipient + " SUCCESSFULLY!!!");
    }

}
