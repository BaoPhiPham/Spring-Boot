package com.chilllearn.loosecoupling.di.v2setter;

public class UserService {
    //Chuyên xử lý data Account/User TABLE trong RAM, sau đó gọi REPO để xuống TABLE
    //Ta cần trợ giúp bên ngoài 2 việc / 2 DEPENDENCY: REPO, SENDER gửi confirm
    //Ta ko tự new, ko nuôi 2 tk này, bên ngoài tiêm chích vào, gọi dịch vụ(có 4 cách)

    private UserRepo userRepo;// ko new, chờ tiêm vào
    private EmailSender emailSender;//ko new, chờ tiêm vào

    //setter tự generate hoặc tự gõ code:

    public UserService() {
    }

    public void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void setEmailSender(EmailSender emailSender) {
        this.emailSender = emailSender;
    }
    //=> cách này dễ hiểu, nhưng cái giá phải trả: NULL cho DEPENDENCY nếu ko gọi setter()
    //Nếu qua Constructor(), bạn ko đưa vào CTOR, thì ko new đc, vì CTOR yêu cầu phải đưa tham số vào thì mới trọn vẹn việc gọi hàm

    //THường giang hồ ưu tiên dùng constructor injection, để ko bị NULL

    //Về Logic, chỗ nào thay Account bằng AccountDto - data transfer object
    //1 Class/Object có nguồn gốc từ Account nhưng nhỏ hơn
    public void registerAccount(Account acc){
        //trong acc có email... mình tự gửi mail theo email này...
        //TODO: logic gọi CRUD của REPO
        //Confirm email:
        //                    acc.email
        emailSender.sendEMail("hongngoctring@gmail.com", "Please check OTP");
    }
}
