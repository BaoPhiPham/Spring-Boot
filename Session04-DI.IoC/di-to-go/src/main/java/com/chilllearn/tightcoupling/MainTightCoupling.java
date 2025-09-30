package com.chilllearn.tightcoupling;

public class MainTightCoupling {
    public static void main(String[] args) {
        //Class MAIN này đóng vai UI, controller, gọi, điều khiển những class ở tần dưới: SERVICE, REPO, JpaUtil,...
        //Sau này thay bằng WEB PAGE, GUI,...
        UserService userService = new UserService();//new SERVICE có sẵn trong lòng 2 DEPENDENCY: Repo và EmailSender
        userService.registerAccount(new Account());
    }
}
