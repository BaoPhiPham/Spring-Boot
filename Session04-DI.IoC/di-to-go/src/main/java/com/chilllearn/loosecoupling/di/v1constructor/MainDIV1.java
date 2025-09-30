package com.chilllearn.loosecoupling.di.v1constructor;

public class MainDIV1 {
    public static void main(String[] args) {
        //Muốn có SERVICE thì phải cần có emailSender trc đã
        EmailSender emailSender = new EmailSender();//DEPENDENCY chủ động lộ mặt, new
        UserService userService = new UserService(emailSender);// chích/tiêm object bên ngoài vào trog SERVICE
        userService.registerAccount(new Account());

        //MAIN CLASS chủ động tạo OBJECT CLASS B, DEPENDENCY, đưa vào trong CLASS chính
        //Thằng chứa, tạo các DEPENDENCY đc gọi là CONTAIER
        //Chủ động tạo DEPENDENCY, đưa vào trong SERVICE CLASS chính A
        //Thì kĩ thuật này code ở trên gọi là IoC, đảo ngược việc kiểm soát tạo OBJECT
        //SERVICE mất bớt quyền, trao bớt quyền, đảo quyền kiểm soát DEPENDENCY
        // => INVERTION OF CONTROL

        //Bữa sau SPRING BOOT thay MAIN, tạo, kiểm soát, tiêm/chích DEPENDENCY cho CLASS chính
        //2 tk SPRING / SPRING-BOOTgọi là IoC CONTAINER
    }
}
