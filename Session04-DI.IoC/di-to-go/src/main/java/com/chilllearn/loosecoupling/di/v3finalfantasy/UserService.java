package com.chilllearn.loosecoupling.di.v3finalfantasy;


public class UserService {

//    private SMSSender smssender;
//    private EmailSender emailSender;
    private UserRepo userRepo;
    //Khai báo smssender, emailSender dnag9 gọi là khai báo cứng cái dependency
    //Ko tốt cho tương lai khi ta cần gửi qua whatsapp
    //=> Ko nên phụ thuộc vào cái cụ thể như ở trên, ta nên phụ thuộc vào cái chung chung để sau này còn dễ bổ sung các bhình thức gửi khác, mà ko cần sửa code của chính class này SERVICE

    private NotiService notiService;//ko new, chờ tiêm chích vào
                                    //Nói chung chung là phụ thuộc vào cái đám gửi infor nhưng ko nói đứa nào, Sms hay email hay...
    //Nhưng chắc chắn 1 điều, object chắc chắn có hàm sendNoti()
    //Code thế nào thì kệ, từ từ tính

    //Chích vào qua FIELD, CONSTRUCTOR, SETTER, tùy chọn nhưng CTOR là oke nhất:
    public UserService(UserRepo userRepo, NotiService notiService) {
        this.userRepo = userRepo;
        this.notiService = notiService;
    }

    public UserService(NotiService notiService) {
        this.notiService = notiService;
    }//Bài này tập trung vào Noti, tiêm từ ngoài vào!!!

    //Gửi noti, ko dám nói gửi mail hay sms hay whatsapp:
//    public void registerAccount(Account acc){
//        //Logic code gọi REPO để  CRUD TABLE ACCOUNT
//        //Gửi noti
//        notiService.sendNoti();
//    }
    //Làm giả việc có thông tin gửi tới ai: To ...
    //GỬi tin nhắn gì, nội dung gì : message...
    //2 thứ ày sẽ trích từ ACCOUNT OBJECT lấy từ form nhập, form đăng kí ở WEB, có đủ ô nhập gồm FULLNAME, ADDRESS, PHONE, EMAIL,...
    public void registerAccount(String to, String message) {
        //gửi noti ko bik chính xác là dịch vụ nào gửi: SMS, MAIL, WHATSAPP
        notiService.sendNoti(to, message);
    }

    //Chích theo SETTER, đổi liều chích khác - OBJECT có quyền đổi trỏ:
    public void setNotiService(NotiService notiService){
        this.notiService = notiService;
    }


}
