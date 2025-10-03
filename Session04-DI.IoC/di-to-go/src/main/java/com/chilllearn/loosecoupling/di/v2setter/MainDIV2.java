package com.chilllearn.loosecoupling.di.v2setter;

public class MainDIV2 {

    //
    public static void main(String[] args) {
        //DEPENDENCY đã lộ diện thya vì hard code bên trong ra ngoài nhà qua setter, nhà mình cần bác thợ ở nơi khác đến giúp, chích/tiêm DEPENDENCY vào setter()
        EmailSender sender = new EmailSender();//ta có hàm gủi mail rồi

        //việc chính là của class UserService
        UserService userService = new UserService();//ch mời bác thợ, vì ko dùng constructor, mà đi qua set()
        userService.setEmailSender(sender );//chích/tiêm dependency vào r
        userService.registerAccount(new Account());
    }
    //Hàm Main(), class main là nơi chưa OBJ DEPENDENCY, vì nó chủ động new EMAIL-SENDER là DEPENDENCY đấy
    //Nơi chưứa các OBJECT DEPENDENCY (Đc NEW) thì gọi là container
    //Và Code chính của ta ko có NEW OBJECT DEPENDENCY ngầm mà chủ động để nơi khác NEW, nơi khác tiêm/chích vào, ta đã đảo ngược (INVERT) tiến trình quản lí OBJECT
    //Ta ko tham lam kiểm soát hết việc tạo OBJECT DEPENDENCY, mà chia bớt ra cho đúa khác tạo, rồi chích vào, truyêền quyền kiểm kahc1 cho ng khác, Mình tập trung dùng thôi, gọi là IoC - Inversion Of Control
    //Ioc là lời khuyên, là nguyên lí, PRINCIPLE, nói thôi về ý tưởng bớt kiểm soát lại mọi chuyện
    //DI: là cách làm cụ thể, IMPLEMENTATION
    //IoC CONTAINER, CONTAINER: nơi chứa OBJECT DEPENDENCY
    //SPRING chính là IoC CONTAINER, sẽ học sớm!!! Thay cho Main, nhưng chcvắ chắn dữ dằn hơn!!!
}
