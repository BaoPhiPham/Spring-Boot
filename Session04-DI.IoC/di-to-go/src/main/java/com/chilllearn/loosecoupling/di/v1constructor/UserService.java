package com.chilllearn.loosecoupling.di.v1constructor;

public class UserService {
    //UserService giỏi CRUD TABLE ACCOUNT, trong RAM
    //UserService cần 2 DEPENDECY, mỗi tk lo 1 việc
    //USER-REPO và EMAIL_SENDER
    private UserRepo userRepo; //Có new hay ko, có là tight-coupling
    // nếu lỏng ra, đó là DI @Autowire nghãi là DI, nghãi là ko FULL CONTROL
    //
    // private EmailSender emailSender = new EmailSender();//full control, ko DI
    //@Autowire - ai đó khác NEW và TIÊM/CHÍCH OBJECT vào cho mình SERVICE
    //-> chỉ dành cho Spring/SpringBoot làm giúp việc new, chích/tiêm
    private EmailSender emailSender;//ko new thì phải đc đưa vào!!!

    //Có nhiều cách đưa OBJ từ ngoài vào trong 1 CLASS
    //1. Trực tiếp qua FIELD, biến emailSender thành public - Nguy hiểm vi phạm ENCAPSULATIO. Vẫn muốn qua FIELD mà PRIVATE - DÙng kĩ thuật nâng cao REFLECTION!!!
    //  -> t.anh gọi là FIELD INJECTION(dùng REFLECTION, IoC FRAMEWORK)
    //2. Truyền vào qua CONSTRUCTOR!!! MLEM Nhất
    //   Tạo OBJECT chính mình qua CONSTRUCTOR và hận thêm đồ qua tham số CONSTRUCTOR
    //    OBJECT DEPENDENCY đi qua, đưa qua CONSTRUCTOR
    //3. SETTER - Truyền qua hàm set() nhưng nếu lười ko gọi set thì DEPENDENCY bị NULL
    //4. Dùng FRAMEWORK/THƯ VIỆN bên ngoài tự kiểm soát tạo OBJECT DEPENDENCY và TIÊM/CHÍCH vào: SPRING/SPRINGBOOT!!!

    // CHÍCH/TIÊM 2 tk DEPENDENCY từ ngoài vào trong SERVICE qua CONSTRUCTOR
    //Y chang truyền yob, gpa -> 2 tk này là primitive, value thuần
    public UserService(UserRepo userRepo, EmailSender emailSender){
        this.userRepo = userRepo;
        this.emailSender = emailSender;
    }
    public UserService(EmailSender emailSender){
        this.emailSender = emailSender;
    }

    public void registerAccount(Account obj){
        //TODO: Dùng REPO xuống TABLE
        //Gửi MAIL confirm:
        //                    acc.email
        emailSender.sendEMail("hongngoctring@gmail.com", "... Please iput the OTP ...");
    }

}
