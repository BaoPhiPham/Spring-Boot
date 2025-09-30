package com.chilllearn.tightcoupling;

//CLASS chính là đây
//GUI  ----  CONTROLLER ----- SERVICE  ----- REPO(JpaUtil) ----- TABLE
public class UserService {
    //C ít nhất 2 DEPENDENCY SERVICE nó cần:
    //1. USER_REPO giúp CRUD TABLE ACCOUNT
    //2. Gửi EMAIL/SMS/WHATSAPP confirm

    private UserRepo userRepo =  new UserRepo();//DEPENDENCY, tight coupling, chủ động quản ký OBJECT DEPENDENCY
    //
    private EmailSender emailSender = new EmailSender();//DEPENDENCY, tight coupling, chủ động tạo OBJECT trong lòng !!!
    //new Service, có 2 chú này đc new luôn!!!
    //=> Hard-code DEPENDENCY, cứng dependency vào đây
    //full-control, direct-control dependency: tự khai báo, tự new!!!
    //Vấn đề: sau này thay SMS, WHATSAPP phải sửa code Class chính này!!!

    //Có nhìu hàm liên quan đến TABLE USER:
    //getAllAccounts, findByEmail, fyByPhone, deleteAccount, updateAccount

    //nhận vào full thông tin account từ cái WEB FORM đăng kí, hoặc nhận vào Dto
    //chứa Email, phone, Whatsapp Id bê trong trích ra
    public void registerAccount(Account acc) {
        //TO DO: gọi REPO để xuống TABLE!!! Xài DEPENDENCY 1
        //Gửi MAIL confirm:
        //                    acc.email
        emailSender.sendEMail("hongngoctring@gmail.com", "... Please iput the OTP ...");
    }
    //Class A: class service
    //Class B: class EmailSender - dependency của A
}
