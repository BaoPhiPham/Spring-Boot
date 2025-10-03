package com.chilllearn.loosecoupling.di.v3finalfantasy;

public interface NotiService {
    //INTERFACE là 1 class cha ko có trong các hàm (ABSTRACT METHOD), sau này có code nhưng nó lạ lắm
    //Về lí thuyết, ko có code thì ko new đc OBJECT vì new xong, chấm gọi hàm, hàm ko có coe thì lấy gì mà chạy
    //Về thực tế INTERFACE đc ví như club, hội nhóm, group khi nó tụ tập ae cùng chí hướng, cùng theo nội quy, quy tắc mà club lập ra
    //Anh em tuân thủ làm theo cách riêng của mỗi ng thì gọi là implement - thi triển, triển khai
    //Nó sẽ móc sang nguyên lí tính đa hình - POLYMORPHISM, từ 1 ra nhiều

    public void sendNoti(String to, String message);//hàm ko có code, chờ ae, members, class con thực thi, triển khai

    //Trên mạng: hàm này chính là cái hợp đồng, CONTRACT mà các anh em phải tuân thủ
}
